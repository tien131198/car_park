package com.example.carpark.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="car")
public class Car {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "license_plate", length = 50, unique = true)
    private String licensePlate;
    @Column(name = "car_color", length = 11)
    private String carColor;
    @Column(name = "car-type", length = 50)
    private String carType;
    @Column(name = "company", length = 50)
    private String company;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "park_id", referencedColumnName = "park_id")
    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
