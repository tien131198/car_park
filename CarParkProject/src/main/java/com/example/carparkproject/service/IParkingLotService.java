package com.example.carpark.service;

import com.example.carpark.entity.ParkingLot;
import com.example.carpark.repository.ParkingLotRepository;
import org.springframework.data.domain.Page;

public interface IParkingLotService {
    public ParkingLot add(ParkingLot parkingLot);
    public ParkingLot update(ParkingLot parkingLot, long id);
    public void delete(long id);
    public Page<ParkingLot> showAll(String sort, int page, int limit);
}
