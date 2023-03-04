package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.health.entity.Diagnostic;

@Repository
public interface DiagnosticDao extends JpaRepository<Diagnostic, String> {

}

