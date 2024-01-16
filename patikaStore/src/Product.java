import java.util.List;
import java.util.Scanner;

public abstract class Product {
    private int id;
    private String name;
    private double price;
    private double discount;
    private int stock;
    private Brand brand;
    private static int count = 1;
    public static Scanner scanner = new Scanner(System.in);

    public Product(String name, double price, double discount, int stock, Brand brand) {
        this.id = count;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.brand = brand;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }





}
