package com.java.se.inheritancePolymorphism.question6;

public class Car extends Vehicle {

    public String licensePlate = null;

    @Override
    public void setLicensePlate(String license) {
        super.setLicensePlate(license);
    }

    @Override
    public String getLicensePlate() {
        return super.getLicensePlate();
    }

//    public void updateCarLicensePlate(String license){
//        this.licensePlate = license;
//    }
//
//    public String getCarLicensePlate(){
//        return this.licensePlate;
//    }
}
