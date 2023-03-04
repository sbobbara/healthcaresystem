package com.cg.health.dto;

public class CreateTestRequest {
	private String testId;
	private String testName;
	public CreateTestRequest() {
	}
	
	public CreateTestRequest(String testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}
	@Override
	public String toString() {
		return "CreateTestRequest [testId=" + testId + ", testName=" + testName + "]";
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
