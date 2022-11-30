package com.example.carpark.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name ="booking_office")
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id", length = 20)
    private long officeId;
    @Column(name = "end_contract_deadline")
    private Date endContractDeadline;
    @Column(name = "office_name", length = 50)
    private String officeName;
    @Column(name = "office_phone", length = 11)
    private String officePhone;
    @Column(name = "office_place", length = 50)
    private String officePlace;
    @Column(name = "office_price", length = 20)
    private long officePrice;
    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "trip_id")
    private Trip trip;
    private Date startContractDeadline;

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public Date getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(Date endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public long getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(long officePrice) {
        this.officePrice = officePrice;
    }

    public Date getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(Date startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }
}
