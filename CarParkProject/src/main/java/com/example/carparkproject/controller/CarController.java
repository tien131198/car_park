package com.example.carpark.controller;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.Car;
import com.example.carpark.service.ICarService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carmanagement/carparkinginlot")
public class CarController {
    private ICarService iCarService;

    public CarController(ICarService iCarService) {
        this.iCarService = iCarService;
    }
    @PostMapping("/add")
    public Car add(@RequestBody Car car) {
        return iCarService.add(car);
    }
    @PutMapping("/update/{id}")
    public Car update(@PathVariable("id") int id,
                                @RequestBody Car car) {
        return iCarService.update(car, id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        iCarService.delete(id);
        return "Delete thanh cong";
    }
    @GetMapping("/views")
    public Page<Car> getAll(@PathParam("page") int page,
                                      @PathParam("sort") String sort,
                                      @PathParam("limit") int limit) {
        Page<Car> carPage = iCarService.showAll(sort, page, limit);
        return carPage;
    }

}
