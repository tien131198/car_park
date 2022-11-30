package com.example.carpark.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", length = 20)
    private long tripId;
    @Column(name = "booked_ticket_number", length = 11)
    private int bookedTicketNumber;
    @Column(name = "car_type", length = 11)
    private String carType;
    @Column(name = "department_date")
    private Date departmentDate;
    @Column(name ="department_time")
    private Time departmentTime;
    @Column(name = "destination", length = 50)
    private String destination;
    @Column(name = "driver", length = 11)
    private String driver;
    @Column(name = "maximum_online_ticket_number", length = 11)
    private int maximumOnlineTicketNumber;

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(Date departmentDate) {
        this.departmentDate = departmentDate;
    }

    public Time getDepartmentTime() {
        return departmentTime;
    }

    public void setDepartmentTime(Time departmentTime) {
        this.departmentTime = departmentTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }
}



