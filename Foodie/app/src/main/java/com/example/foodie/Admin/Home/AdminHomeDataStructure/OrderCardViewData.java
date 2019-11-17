package com.example.foodie.Admin.Home.AdminHomeDataStructure;

import java.util.List;

public class OrderCardViewData {
    private String customerName;
    private String orderTime;
    private int orderId;
    private double totalPrice;
    private String readyTime;
    private String message;
    private int imageResourceId;
    private List<AdminHomeOrderItemData> subItems;

    public OrderCardViewData(String customerName, String orderTime, int orderId, double totalPrice, String readyTime, String message, int imageResourceId, List<AdminHomeOrderItemData> subItems) {
        this.customerName = customerName;
        this.orderTime = orderTime;
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.readyTime = readyTime;
        this.message = message;
        this.imageResourceId = imageResourceId;
        this.subItems = subItems;
    }

    public OrderCardViewData(String customerName, String orderTime, int orderId, double totalPrice, String readyTime, String message, List<AdminHomeOrderItemData> subItems) {
        this.customerName = customerName;
        this.orderTime = orderTime;
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.readyTime = readyTime;
        this.message = message;
        this.subItems = subItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getReadyTime() {
        return readyTime;
    }

    public String getMessage() {
        return message;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
    public List<AdminHomeOrderItemData> getSubItems() {
        return subItems;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setReadyTime(String readyTime) {
        this.readyTime = readyTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setSubItems(List<AdminHomeOrderItemData> subItems) {
        this.subItems = subItems;
    }
}
