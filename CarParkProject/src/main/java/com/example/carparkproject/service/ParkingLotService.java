package com.example.carpark.service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.ParkingLot;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.ParkingLotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService implements IParkingLotService{
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingLot add(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLot update(ParkingLot parkingLot, long id) {
        ParkingLot p = parkingLotRepository.findById(id).orElse(null);
        if(p == null){
            throw new NotFoundException();
        }else{
            p.setParkArea(parkingLot.getParkArea());
            p.setParkName(parkingLot.getParkName());
            p.setParkPlace(parkingLot.getParkPlace());
            p.setParkStatus(parkingLot.getParkStatus());
            p.setParkArea(parkingLot.getParkArea());
        }
        return p;
    }

    @Override
    public void delete(long id) {
        parkingLotRepository.deleteById(id);

    }

    @Override
    public Page<ParkingLot> showAll(String sort, int page, int limit) {
        Sort sortable = null;
        if(sort.equals("asc")){
            sortable =Sort.by("parkName").ascending();
        }
        if(sort.equals("desc")){
            sortable = Sort.by("parkName").descending();
        }
        Pageable pageable = PageRequest.of(page, limit, sortable);
        return parkingLotRepository.findAll(pageable);
    }
}
