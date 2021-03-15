package com.entity;


public class Car {
    private String brand;
    private double price;
    private User user;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
