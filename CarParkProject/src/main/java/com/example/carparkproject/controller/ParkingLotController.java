package com.example.carpark.controller;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.ParkingLot;
import com.example.carpark.service.IBookingOfficeService;
import com.example.carpark.service.IParkingLotService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Parkinglot")
public class ParkingLotController {
    private IParkingLotService iParkingLotService;

    public ParkingLotController(IParkingLotService iParkingLotService) {
        this.iParkingLotService = iParkingLotService;
    }

    @PostMapping("/add")
    public ParkingLot add(@RequestBody ParkingLot parkingLot) {
        return iParkingLotService.add(parkingLot);
    }
    @PutMapping("/update/{id}")
    public ParkingLot update(@PathVariable("id") int id,
                                @RequestBody ParkingLot parkingLot) {
        return iParkingLotService.update(parkingLot, id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        iParkingLotService.delete(id);
        return "Delete thanh cong";
    }
    @GetMapping("/views")
    public Page<ParkingLot> getAll(@PathParam("page") int page,
                                      @PathParam("sort") String sort,
                                      @PathParam("limit") int limit) {
        Page<ParkingLot> parkingLotPage = iParkingLotService.showAll(sort, page, limit);
        return parkingLotPage;
    }
}
