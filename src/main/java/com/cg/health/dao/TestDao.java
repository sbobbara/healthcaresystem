package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.health.dto.Test;
import com.cg.health.entity.TestDetails;

public interface TestDao extends  JpaRepository<TestDetails, String>  {

	Test save(Test test);

}