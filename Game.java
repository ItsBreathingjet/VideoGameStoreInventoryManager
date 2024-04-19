import java.io.*;
import java.util.*;

public class Game extends VideoGameStore{
    private String type;
    private String title;
    private double price;
    private String rating;
    private int amountInStock;
    public Game(String type, String title, double price, String rating, int amountInStock) {
        this.type=type;
        this.title=title;
        this.price=price;
        this.rating=rating;
        this.amountInStock=amountInStock;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type=type;

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title=title;

    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price=price;

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating=rating;
    }
    public int getAmountInStock() {
        return amountInStock;
    }
    public void setAmountInStock(int amountInStock) {
        this.amountInStock=amountInStock;
    }
    public Game fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 5) {
            String type = parts[0];
            String title = parts[1];
            double price = Double.parseDouble(parts[2]);
            String rating = parts[3];
            int amountInStock = Integer.parseInt(parts[4]);
            return new Game(type, title, price, rating, amountInStock);
        } else {
            // Return null if line format is invalid
            return null;
        }
    }
    public String toString() {
    return "Game {" +"type= '" + type + '\'' +", title= '" + title + '\'' +", price= " + price +", rating= '" + rating + '\'' +", amountInStock= " + amountInStock +'}';
    }
    public String toCSVString() {
    return type + "," + title + "," + price + "," + rating + "," + amountInStock;
    }


}