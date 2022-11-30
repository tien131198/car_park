package com.example.carpark.service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.Car;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car add(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car, long id) {
        Car c = carRepository.findById(id).orElse(null);
        if(c == null){
            throw new NotFoundException();
        }else{
            c.setLicensePlate(car.getLicensePlate());
            c.setCarColor(car.getCarColor());
            c.setCarType(car.getCarType());
            c.setCompany(car.getCompany());
            c.setParkingLot(car.getParkingLot());
        }
        return c;
    }

    @Override
    public void delete(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Page<Car> showAll(String sort, int page, int limit) {
        Sort sortable = null;
        if (sort.equals("asc")) {
            sortable = Sort.by("licensePlate").ascending();
        }
        if (sort.equals("desc")) {
            sortable = Sort.by("licensePlate").descending();
        }
        Pageable pageable = PageRequest.of(page, limit, sortable);
        return carRepository.findAll(pageable);
    }
}

