package com.example.carpark.service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.BookingOfficeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookingOfficerService implements IBookingOfficeService {
    private BookingOfficeRepository bookingOfficeRepository;

    public BookingOfficerService(BookingOfficeRepository bookingOfficeRepository) {
        this.bookingOfficeRepository = bookingOfficeRepository;
    }

    @Override
    public BookingOffice add(BookingOffice bookingOffice) {
        return bookingOfficeRepository.save(bookingOffice);
    }

    @Override
    public BookingOffice update(BookingOffice bookingOffice, long id) {
        BookingOffice b = bookingOfficeRepository.findById(id).orElse(null);
        if(b == null){
            throw new NotFoundException();
        }else{
            b.setOfficeName(bookingOffice.getOfficeName());
            b.setOfficePhone(bookingOffice.getOfficePhone());
            b.setOfficePlace(bookingOffice.getOfficePlace());
            b.setOfficePrice(bookingOffice.getOfficePrice());
            b.setStartContractDeadline(bookingOffice.getStartContractDeadline());
            b.setEndContractDeadline(bookingOffice.getEndContractDeadline());
        }
        return b;
    }

    @Override
    public void delete(long id) {
        bookingOfficeRepository.deleteById(id);
    }

    @Override
    public Page<BookingOffice> showAll(String sort, int page, int limit) {
        Sort sortable = null;
        if(sort.equals("asc")){
            sortable =Sort.by("officeName").ascending();
        }
        if(sort.equals("desc")){
            sortable = Sort.by("officeName").descending();
        }
        Pageable pageable = PageRequest.of(page, limit, sortable);
        return bookingOfficeRepository.findAll(pageable);
    }
}
