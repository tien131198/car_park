package com.example.carpark.service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.Ticket;
import org.springframework.data.domain.Page;

public interface ITicketService {
    public Ticket add(Ticket ticket);
    public Ticket update(Ticket ticket, long id);
    public void delete(long id);
    public Page<Ticket> showAll(String sort, int page, int limit);
}
