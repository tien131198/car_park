package com.example.carpark.controller;

import com.example.carpark.entity.Ticket;
import com.example.carpark.entity.Trip;
import com.example.carpark.service.ITripService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tripmanagement")
public class TripController {
    private ITripService iTripService;

    public TripController(ITripService iTripService) {
        this.iTripService = iTripService;
    }
    @PostMapping("/add")
    public Trip add(@RequestBody Trip trip) {
        return iTripService.add(trip);
    }
    @PutMapping("/update/{id}")
    public Trip update(@PathVariable("id") int id,
                         @RequestBody Trip trip) {
        return iTripService.update(trip, id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        iTripService.delete(id);
        return "Delete thanh cong";
    }
    @GetMapping("/views")
    public Page<Trip> getAll(@PathParam("page") int page,
                               @PathParam("sort") String sort,
                               @PathParam("limit") int limit) {
        Page<Trip> tripPage = iTripService.showAll(sort, page, limit);
        return tripPage;
    }
}
