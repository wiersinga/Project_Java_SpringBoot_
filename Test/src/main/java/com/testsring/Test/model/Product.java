package com.testsring.Test.model;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private int price;
    private Date releaseDate;
    private String serieNumber;


    public Product(int id, String name, int price, Date releaseDate, String serieNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.serieNumber = serieNumber;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId(int id) {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSerieNumber() {
        return serieNumber;
    }

    public void setSerieNumber(String serieNumber) {
        this.serieNumber = serieNumber;
    }

    public Product findById(int id) {
        return null;
    }
}


