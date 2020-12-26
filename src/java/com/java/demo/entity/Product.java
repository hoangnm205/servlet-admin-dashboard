/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.entity;

/**
 *
 * @author hoangnghiem
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int category;
    private boolean hot;
    
    public Product() {
    }

    public Product(int id, String name, double price, int category, boolean hot) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.hot = hot;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }


    public int getId() {
        return id;
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
    
}
