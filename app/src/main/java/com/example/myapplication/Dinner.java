package com.example.myapplication;

public class Dinner {
    private String dinnerType;
    private String delivery;
    private double price;
    private String payment;

    public Dinner (String dinnerType,String delivery,double price,String payment){
        this.dinnerType = dinnerType;
        this.delivery = delivery;
        this.price = price;
        this.payment = payment;
    }
    public String getDinnerType(){
        return dinnerType;
    }
    public void setDinnerType(String dinnerType){
        this.dinnerType = dinnerType;
    }
    public String getDelivery(){
        return delivery;
    }
    public void setDelivery(String delivery){
        this.delivery = delivery;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getPayment(){
        return payment;
    }
    public void setPayment(String payment){
        this.payment = payment;
    }
}
