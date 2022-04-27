package com.example.maiaraalmeida_comp304_lab2_exerc01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class GetHouse {

    private String homeType;
    private double price;
    private String imgPath;
    private String address;
    private boolean visitInPerson;
    private static int id=0;

    public static ArrayList<GetHouse> getHomeList = new ArrayList<GetHouse>();




    public GetHouse(String homeType, double price, String imgPath, String address) {

        this.homeType = homeType;
        this.price = price;
        this.imgPath = imgPath;
        this.address = address;
        id+=1;

    }

    public int getId() {
        return id;
    }

    public boolean isVisitInPerson() {
        return visitInPerson;
    }

    public void setVisitInPerson(boolean visitInPerson) {
        this.visitInPerson = visitInPerson;
    }

    public boolean isVisitVirtual() {
        return VisitVirtual;
    }

    public void setVisitVirtual(boolean visitVirtual) {
        VisitVirtual = visitVirtual;
    }

    private boolean VisitVirtual;



    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}