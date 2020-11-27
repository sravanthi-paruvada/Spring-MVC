package com.zoo;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vet implements Serializable{
	
	@Id
	@GeneratedValue
	private int vetId;
	
	private String vetName;
	private String vetQualification;
	
	
	
	
	public Vet(String vetName, String vetQualification) {
	
		this.vetName = vetName;
		this.vetQualification = vetQualification;
	}
	public Vet() {
		
	}
	public int getVetId() {
		return vetId;
	}
	public void setVetId(int vetId) {
		this.vetId = vetId;
	}
	public String getVetName() {
		return vetName;
	}
	public void setVetName(String vetName) {
		this.vetName = vetName;
	}
	public String getVetQualification() {
		return vetQualification;
	}
	public void setVetQualification(String vetQualification) {
		this.vetQualification = vetQualification;
	}
	
	
	
	

}
