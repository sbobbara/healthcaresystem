package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.health.entity.UserDetails;

public interface Logout extends JpaRepository<UserDetails, String>{

}
