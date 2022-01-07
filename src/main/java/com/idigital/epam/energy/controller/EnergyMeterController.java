package com.idigital.epam.energy.controller;


import com.idigital.epam.energy.entity.EnergyMeter;
import com.idigital.epam.energy.entity.Home;
import com.idigital.epam.energy.payload.EnergyMeterRequest;
import com.idigital.epam.energy.payload.Response;
import com.idigital.epam.energy.service.EnergyMeterService;
import com.idigital.epam.energy.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/energymeter")
//@CrossOrigin(maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnergyMeterController {

    @Autowired
    EnergyMeterService energyMeterService;

    @Autowired
    HomeService homeService;

    @PostMapping("/save")
    public ResponseEntity<Response> createEnergyMeter(@RequestBody EnergyMeterRequest energyMeterRequest) throws Exception {
        return ResponseEntity.ok(energyMeterService.create(energyMeterRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EnergyMeter>> getAll(){
        List<EnergyMeter> energyMeters = energyMeterService.getAll();
        return new ResponseEntity<>(energyMeters, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EnergyMeter> getEnergyMeterById(@PathVariable Long id){
        EnergyMeter energyMeter = energyMeterService.getById(id);
        return ResponseEntity.ok(energyMeter);
    }

}


