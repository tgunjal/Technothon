package com.technothon.multimodel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technothon.multimodel.entity.LaboratoryData;

public interface LaboratoryDataRepository extends JpaRepository<LaboratoryData, Integer> {

}
