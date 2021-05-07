package de.dhbw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    private final String MOVIETITEL = "I am an Movie";
    private final int PRICECODE = 2;

    private Movie movieForTesting;


    @BeforeEach
    void setUp() {
        movieForTesting = new Movie(MOVIETITEL, PRICECODE);
    }

    @Test
    void getPriceCode() {
        assertEquals(PRICECODE, movieForTesting.getPriceCode());
    }

    @Test
    void getTitle() {
        assertEquals(MOVIETITEL, movieForTesting.getTitle());
    }
}