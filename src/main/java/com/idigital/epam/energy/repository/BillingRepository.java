package com.idigital.epam.energy.repository;

import com.idigital.epam.energy.entity.Billing;
import com.idigital.epam.energy.entity.EnergyMeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {


    List<Billing> findByEnergyMeter(EnergyMeter energyMeter);
}
