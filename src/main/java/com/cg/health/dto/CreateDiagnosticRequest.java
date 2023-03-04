package com.cg.health.dto;

public class CreateDiagnosticRequest {
	private String centreId;	
    private String centreName;
    
    
	public CreateDiagnosticRequest() {
	}
	
	public CreateDiagnosticRequest(String centreId, String centreName) {
		super();
		this.centreId = centreId;
		this.centreName = centreName;
	}
	
	@Override
	public String toString() {
		return "CreateDiagnosticRequest [centreId=" + centreId + ", centreName=" + centreName + "]";
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
