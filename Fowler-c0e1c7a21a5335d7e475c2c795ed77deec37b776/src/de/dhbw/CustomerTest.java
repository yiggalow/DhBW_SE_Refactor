package de.dhbw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    final String CUSTOMERNAME = "CustomerName";
    final String MOVIETITEL = "I am an Movie";
    final int PRICECODE = 2;
    final int RENTINGDAYS = 15;

    final String RESULTSTRING = "de.dhbw.Rental Record for "+CUSTOMERNAME+"\n" +
            "\tTitle\t\tDays\tAmount\n" +
            "\t"+MOVIETITEL+"\t\t"+RENTINGDAYS+"\t19.5\n" +
            "Amount owed is 19.5\n"+
            "You earned 1 frequent renter points";

    Movie movieForTesting;
    Rental rentalForTesting;
    Customer customerForTesting;

    @BeforeEach
    void setUp() {
        customerForTesting = new Customer(CUSTOMERNAME);
        movieForTesting = new Movie(MOVIETITEL,PRICECODE);
        rentalForTesting = new Rental(movieForTesting,RENTINGDAYS);
    }

    @Test
    void addRental() {
        customerForTesting.addRental(rentalForTesting);
    }

    @Test
    void getName() {
        assertEquals(CUSTOMERNAME,customerForTesting.getName());
    }

    @Test
    void statement() {

        customerForTesting.addRental(rentalForTesting);
        assertEquals(RESULTSTRING,customerForTesting.statement());
    }
}