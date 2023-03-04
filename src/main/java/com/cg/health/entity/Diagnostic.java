package com.cg.health.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dia_center")
public class Diagnostic {
	@Id
	private String centreId;
	private String centreName;
	
	public Diagnostic() {
	}
	
	public Diagnostic(String centreId, String centreName) {
		super();
		this.centreId=centreId;
		this.centreName=centreName;
	}
	
	@Override
	public String toString() {
		return "Diagnostic [centreId=" + centreId + ", centreName=" + centreName + "]";
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
