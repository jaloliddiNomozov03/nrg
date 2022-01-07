package com.idigital.epam.energy.service;

import com.idigital.epam.energy.entity.EnergyMeter;
import com.idigital.epam.energy.payload.EnergyMeterRequest;
import com.idigital.epam.energy.payload.Response;

public interface EnergyMeterService extends CommonService<EnergyMeter> {

    public Response create(EnergyMeterRequest data) throws Exception;

    EnergyMeter getAllEnergyMeter();
}
