package de.dhbw;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    Price price;
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

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }
    int getFrequentRenterPoints(int daysRented) {
        if ((price.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else
            return 1;
    }
}