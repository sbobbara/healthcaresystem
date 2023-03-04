package com.cg.health.dto;

public class DiagnosticDetails {
	private String centreId;
	private String centreName;
	
	public DiagnosticDetails() {
	
	}
	public DiagnosticDetails(String centreId, String centreName) {
		super();
		this.centreId = centreId;
		this.centreName = centreName;
	}
	@Override
	public String toString() {
		return "DiagonsticDetais [centreId=" + centreId + ", centreName=" + centreName + "]";
	}
	public String getCentreId() {
		return centreId;
	}
	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}
	public String getCentreName() {
		return centreName;
	}
	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}
	
	
	
}
