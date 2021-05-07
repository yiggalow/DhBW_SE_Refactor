package de.dhbw;

import static org.junit.jupiter.api.Assertions.*;
class RentalTest {
    private final String MOVIETITEL = "I am an Movie";
    private final int PRICECODE = 2;
    private final int RENTINGDAYS = 15;

    private Movie movieForTesting;
    private Rental rentalForTesting;

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