package com.example.carpark.service;

import com.example.carpark.entity.Car;
import com.example.carpark.entity.ParkingLot;
import org.springframework.data.domain.Page;

public interface ICarService {
    public Car add(Car car);
    public Car update(Car car, long id);
    public void delete(long id);
    public Page<Car> showAll(String sort, int page, int limit);
}
