package com.technothon.multimodel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technothon.multimodel.entity.BioMarker;

public interface BioMarkerRepository extends JpaRepository<BioMarker, Integer> {

}
