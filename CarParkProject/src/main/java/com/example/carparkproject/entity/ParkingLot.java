package com.example.carpark.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="parking_lot")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "park_id", length = 20)
    private long parkId;
    @Column(name = "park_area", length = 20)
    private long parkArea;
    @Column(name = "park_name", length = 50)
    private String parkName;
    @Column(name = "park_place", length = 11)
    private String parkPlace;
    @Column(name = "park_price", length = 20)
    private long parkPrice;
    @Column(name = "park_status", length = 50)
    private String parkStatus;

    public long getParkId() {
        return parkId;
    }

    public void setParkId(long parkId) {
        this.parkId = parkId;
    }

    public long getParkArea() {
        return parkArea;
    }

    public void setParkArea(long parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public long getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }
}
