package com.example.carpark.controller;

import com.example.carpark.entity.Car;
import com.example.carpark.entity.Ticket;
import com.example.carpark.service.ITicketService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticketmanagement/list")
public class TicketController {
    private ITicketService iTicketService;

    public TicketController(ITicketService iTicketService) {
        this.iTicketService = iTicketService;
    }
    @PostMapping("/add")
    public Ticket add(@RequestBody Ticket ticket) {
        return iTicketService.add(ticket);
    }
    @PutMapping("/update/{id}")
    public Ticket update(@PathVariable("id") int id,
                      @RequestBody Ticket ticket) {
        return iTicketService.update(ticket, id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        iTicketService.delete(id);
        return "Delete thanh cong";
    }
    @GetMapping("/views")
    public Page<Ticket> getAll(@PathParam("page") int page,
                            @PathParam("sort") String sort,
                            @PathParam("limit") int limit) {
        Page<Ticket> ticketPage = iTicketService.showAll(sort, page, limit);
        return ticketPage;
    }
}
