package com.idigital.epam.energy.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EnergyMeterRequest {

    private Long homeId;
//    private String energyMeterTraffic;
    private Integer energyConsumption;


}
