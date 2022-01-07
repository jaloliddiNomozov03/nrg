package com.idigital.epam.energy.service.DTO;

import lombok.Data;

@Data
public class BillingRequest {

    private Integer previousReading;
    private Integer currentReading;
    private Integer amountEnergyConsumption;
    private Integer Sum;

    private Long energyMeterId;



}
