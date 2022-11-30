package com.example.carpark.service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.Employee;
import org.springframework.data.domain.Page;

public interface IBookingOfficeService {
    public BookingOffice add(BookingOffice bookingOffice);
    public BookingOffice update(BookingOffice bookingOffice, long id);
    public void delete(long id);
    public Page<BookingOffice> showAll(String sort, int page, int limit);
}
