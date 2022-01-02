package com.example.foodapp.Models;

public class OrderShowModel {
    int orderedImage;
    String orderedFood,orderedPrice,orderNumber;

    public OrderShowModel() {

    }

    public int getOrderedImage() {
        return orderedImage;
    }

    public void setOrderedImage(int orderedImage) {
        this.orderedImage = orderedImage;
    }

    public String getOrderedFood() {
        return orderedFood;
    }

    public void setOrderedFood(String orderedFood) {
        this.orderedFood = orderedFood;
    }

    public String getOrderedPrice() {
        return orderedPrice;
    }

    public void setOrderedPrice(String orderedPrice) {
        this.orderedPrice = orderedPrice;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public OrderShowModel(int orderedImage, String orderedFood, String orderedPrice, String orderNumber) {
        this.orderedImage = orderedImage;
        this.orderedFood = orderedFood;
        this.orderedPrice = orderedPrice;
        this.orderNumber = orderNumber;
    }
}
