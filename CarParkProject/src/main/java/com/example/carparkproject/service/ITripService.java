package com.example.carpark.service;

import com.example.carpark.entity.Ticket;
import com.example.carpark.entity.Trip;
import org.springframework.data.domain.Page;

public interface ITripService {
    public Trip add(Trip trip);
    public Trip update(Trip trip, long id);
    public void delete(long id);
    public Page<Trip> showAll(String sort, int page, int limit);
}
