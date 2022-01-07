package com.idigital.epam.energy.service.Impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.idigital.epam.energy.entity.EnergyMeter;
import com.idigital.epam.energy.entity.Home;
import com.idigital.epam.energy.payload.EnergyMeterRequest;
import com.idigital.epam.energy.payload.Response;
import com.idigital.epam.energy.repository.EnergyMeterRepository;
import com.idigital.epam.energy.repository.HomeRepository;
import com.idigital.epam.energy.service.EnergyMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class EnergyMeterServiceImpl implements EnergyMeterService {

    @Autowired
    EnergyMeterRepository energyMeter;

    @Autowired
    HomeRepository homeRepository;

    @Override
    public List<EnergyMeter> getAll() {

        return energyMeter.findAll();
    }

    @Override
    public EnergyMeter getById(Long id) {
        //return Optional.of(energyMeter.findById(id)).filter(Optional::isPresent).get().get();
        return energyMeter.getById(id);
    }

    @Override
    public Response create(EnergyMeterRequest data) throws Exception {

            Home home = homeRepository.findById(data.getHomeId()).get();
            EnergyMeter energyMeter1r=new EnergyMeter();
            energyMeter1r.setEnergyConsumption(data.getEnergyConsumption());
            energyMeter1r.setHome(home);

            energyMeter.save(energyMeter1r);
            return new Response("Saved",Boolean.TRUE);
    }

    @Override
    public EnergyMeter getAllEnergyMeter() {

       return null;
    }


    @Override
    public EnergyMeter update(EnergyMeter data) throws Exception {
        if (data.getId() != null){
            return energyMeter.save(data);
        }
        throw new Exception("id shouldn't be null");
    }

    @Override
    public void delete(EnergyMeter data) {
        energyMeter.deleteById(data.getId());
    }

}
