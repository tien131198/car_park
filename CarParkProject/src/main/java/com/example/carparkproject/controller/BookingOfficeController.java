package com.example.carparkproject.controller;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.Employee;
import com.example.carpark.service.IBookingOfficeService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookingoffice")
public class BookingOfficeController {
    private IBookingOfficeService iBookingOfficeService;

    public BookingOfficeController(IBookingOfficeService iBookingOfficeService) {
        this.iBookingOfficeService = iBookingOfficeService;
    }
    @PostMapping("/add")
    public BookingOffice add(@RequestBody BookingOffice bookingOffice) {
        return iBookingOfficeService.add(bookingOffice);
    }
    @PutMapping("/update/{id}")
    public BookingOffice update(@PathVariable("id") int id,
                                   @RequestBody BookingOffice bookingOffice) {
        return iBookingOfficeService.update(bookingOffice, id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        iBookingOfficeService.delete(id);
        return "Delete thanh cong";
    }
    @GetMapping("/views")
    public Page<BookingOffice> getAll(@PathParam("page") int page,
                                      @PathParam("sort") String sort,
                                      @PathParam("limit") int limit) {
        Page<BookingOffice> bookingOfficePage = iBookingOfficeService.showAll(sort, page, limit);
        return bookingOfficePage;
    }

}
