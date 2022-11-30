package com.example.carpark.service;

import com.example.carpark.entity.Ticket;
import com.example.carpark.entity.Trip;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.TripRepository;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TripService implements ITripService {
    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip add(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip update(Trip trip, long id) {
        Trip t = tripRepository.findById(id).orElse(null);
        if (t == null) {
            throw new NotFoundException();
        } else {
            t.setCarType(trip.getCarType());
            t.setBookedTicketNumber(trip.getBookedTicketNumber());
            t.setDriver(trip.getDriver());
            t.setDestination(trip.getDestination());
            t.setDepartmentDate(trip.getDepartmentDate());
            t.setBookedTicketNumber(trip.getBookedTicketNumber());
            t.setDepartmentTime(trip.getDepartmentTime());
            t.setMaximumOnlineTicketNumber(trip.getMaximumOnlineTicketNumber());
        }
        return t;
    }

    @Override
    public void delete(long id) {
        tripRepository.deleteById(id);
    }

    @Override
    public Page<Trip> showAll(String sort, int page, int limit) {
        Sort sortable = null;
        if (sort.equals("asc")) {
            sortable = Sort.by("destination").ascending();
        }
        if (sort.equals("desc")) {
            sortable = Sort.by("destination").descending();
        }
        Pageable pageable = PageRequest.of(page, limit, sortable);
        return tripRepository.findAll(pageable);
    }
}
