package de.dhbw;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price price;
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }
    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
    public String getTitle (){
        return title;
    };

    public double getCharge(int getDaysRented) {
        double rentalAmount = 0;
        switch (price.getPriceCode()) {
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
        if ((price.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else
            return 1;
    }
}