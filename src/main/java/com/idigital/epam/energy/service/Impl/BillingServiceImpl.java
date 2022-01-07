package com.idigital.epam.energy.service.Impl;

import com.idigital.epam.energy.entity.Billing;
import com.idigital.epam.energy.entity.EnergyMeter;
import com.idigital.epam.energy.repository.BillingRepository;
import com.idigital.epam.energy.service.BillingService;
import com.idigital.epam.energy.service.DTO.BillingRequest;
import com.idigital.epam.energy.service.EnergyMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {
    @Autowired
    BillingRepository billingRepository;

    @Autowired
    EnergyMeterService energyMeterService;

    @Override
    public List<Billing> getAll() {
        return billingRepository.findAll();
    }



    @Override
    public Billing getById(Long id) {
        return Optional.of(billingRepository.findById(id)).filter(Optional::isPresent).get().get();
    }

    @Override
    public Billing create(BillingRequest billingRequest) {

        Billing billing = new Billing();
        billing.setPreviousReading(billingRequest.getPreviousReading());
        billing.setCurrentReading(billingRequest.getCurrentReading());
        billing.setAmountEnergyConsumption(billingRequest.getAmountEnergyConsumption());
        billing.setSum(billingRequest.getSum());
        EnergyMeter energyMeter = energyMeterService.getById(billingRequest.getEnergyMeterId());
        billing.setEnergyMeter(energyMeter);
            return billingRepository.save(billing);

    }

    @Override
    public Billing update(Billing billing) throws Exception{

        if(billingRepository.findById(billing.getId())!=null){
            billingRepository.save(billing);
            return billingRepository.getOne(billing.getId());
        }else{
            throw new Exception("Billing Not found for Id "+billing.getId());
        }

    }

      @Override
    public void deleteById(Long id) throws Exception {

          if(billingRepository.findById(id)!=null){
              billingRepository.deleteById(id);

          }else{
              throw new Exception("Billing Not found for Id "+id);
          }


    }

    @Override
    public void delete(Billing billing){

    }
}
