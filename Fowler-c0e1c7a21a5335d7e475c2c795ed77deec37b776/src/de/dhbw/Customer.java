package de.dhbw;

import java.lang.*;
import java.util.*;

class Customer {
    private String customerName;
    private Vector rentals = new Vector();
    public Customer (String customerName){
        this.customerName = customerName;
    };
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    };
    public String getName (){
        return customerName;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentalEnum = rentals.elements();
        String resultStatement = "de.dhbw.Rental Record for " + this.getName() + "\n";
        resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentalEnum.hasMoreElements()) {
            double currentAmount = 0;
            Rental each = (Rental) rentalEnum.nextElement();
            //determine amounts for each line
            currentAmount = each.getCharge();
            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
            resultStatement += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        resultStatement += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        resultStatement += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return resultStatement;
    }
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<h1>Rentals for <em>" + getName() + "</em></h1><p>\n";
        while (rentals.hasMoreElements()) {
            Rental currentRental = (Rental) rentals.nextElement();
            //show figures for each rental
            result += currentRental.getMovie().getTitle() + ": " +
                    String.valueOf(currentRental.getCharge()) + "<br>\n";
        }
        //add footer lines
        result += "</p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em><p>\n";
        result += "On this rental you earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em> frequent renter points</p>";
        return result;
    }

}
    