package com.cg.health.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_details")
public class TestDetails {
	@Id
	private String testId;
	private String testName;
	public TestDetails(String testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}
	public TestDetails() {
	}
	@Override
	public String toString() {
		return "TestDetails [testId=" + testId + ", testName=" + testName + "]";
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}

}