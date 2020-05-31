package model;

public class Seller extends Worker {
    private int amountOfSales;

    public Seller(String name, int ID) {
        super(name, ID);
    }

    public int getAmountOfSales() {
        return amountOfSales;
    }

    public void setAmountOfSales(int amountOfSales) {
        this.amountOfSales = amountOfSales;
    }
}
