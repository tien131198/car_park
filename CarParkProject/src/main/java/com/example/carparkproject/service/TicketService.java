package com.example.carpark.service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.Ticket;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.TicketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket add(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(Ticket ticket, long id) {
        Ticket t = ticketRepository.findById(id).orElse(null);
        if(t == null){
            throw new NotFoundException();
        }else{
            t.setCar(ticket.getCar());
            t.setBookingTime(ticket.getBookingTime());
            t.setTrip(ticket.getTrip());
            t.setCustomerName(ticket.getCustomerName());
        }
        return t;
    }

    @Override
    public void delete(long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Page<Ticket> showAll(String sort, int page, int limit) {
        Sort sortable = null;
        if (sort.equals("asc")) {
            sortable = Sort.by("customerName").ascending();
        }
        if (sort.equals("desc")) {
            sortable = Sort.by("customerName").descending();
        }
        Pageable pageable = PageRequest.of(page, limit, sortable);
        return ticketRepository.findAll(pageable);
    }
}
