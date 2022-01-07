package com.idigital.epam.energy.service;

import com.idigital.epam.energy.entity.Billing;
import com.idigital.epam.energy.entity.EnergyMeter;
import com.idigital.epam.energy.entity.User;
import com.idigital.epam.energy.service.DTO.BillingRequest;

public interface BillingService  extends CommonService<Billing>{

    public Billing create(BillingRequest billingRequest);
    public Billing update(Billing billing)  throws Exception;
    public void deleteById(Long id)  throws Exception;



}
