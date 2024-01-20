package book;

import authur.Authur;

public class Book {
    private String name;
    private Authur[] authurs;
    private double price;
    private int qty;

    public Book(String name, Authur[] authurs, double price) {
        this.name = name;
        this.authurs = authurs;
        this.price = price;
    }

    public Book(String name, Authur[] authurs, double price, int qty) {
        this.name = name;
        this.authurs = authurs;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return this.name;
    }

    public Authur[] getAuthurs() {
        return this.authurs;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        String authurName = "";
        for (Authur authur : authurs) {
            authurName += "Authur[name=" + authur.getName() + ",email=" + authur.getEmail() + ",gender=" + authur.getGender() + "],";
        }
        return "Book[name=" + this.getName() + "authurs={" + authurName + "},price=" + this.getPrice() + ",qty=" + this.getQty() + "]";
    }

    public String getAuthursNames(){
        String authurName = "";
        for (Authur authur : authurs){
            authurName += authur.getName();
        }
        return authurName;
    }
}
