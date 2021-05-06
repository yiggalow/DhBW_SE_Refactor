package de.dhbw;

import static org.junit.jupiter.api.Assertions.*;
class RentalTest {
    final String MOVIETITEL = "I am an Movie";
    final int PRICECODE = 2;
    final int RENTINGDAYS = 15;

    Movie movieForTesting;
    Rental rentalForTesting;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        movieForTesting = new Movie(MOVIETITEL, PRICECODE);
        rentalForTesting = new Rental(movieForTesting, RENTINGDAYS);
    }

    @org.junit.jupiter.api.Test
    void getDaysRented() {
        assertEquals(RENTINGDAYS,rentalForTesting.getDaysRented());
    }

    @org.junit.jupiter.api.Test
    void getMovie() {
        assertEquals(movieForTesting, rentalForTesting.getMovie());
    }
}