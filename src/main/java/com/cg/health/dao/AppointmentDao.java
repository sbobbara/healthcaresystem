package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.health.entity.AppointmentDetails;

@Repository
public interface AppointmentDao extends JpaRepository<AppointmentDetails, Long> {

}