package de.dhbw;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }
    public int getPriceCode() {
        return priceCode;
    }
    public String getTitle (){
        return title;
    };

    public double getCharge(int getDaysRented) {
        double rentalAmount = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (getDaysRented > 2)
                    rentalAmount += (getDaysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += getDaysRented * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (getDaysRented > 3)
                    rentalAmount += (getDaysRented - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }
    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) return 2;
        else return 1;
    }
}