package com.zoo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class External_Vet extends Vet{
	
	private String country;
	private int visitingFee;

	
	public External_Vet() {
		
	}


	public External_Vet(String vetName, String vetQualification, String country, int visitingFee) {
		super(vetName, vetQualification);
		this.country = country;
		this.visitingFee = visitingFee;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getVisitingFee() {
		return visitingFee;
	}


	public void setVisitingFee(int visitingFee) {
		this.visitingFee = visitingFee;
	}


	@Override
	public String toString() {
		return "External_Vet [country=" + country + ", visitingFee=" + visitingFee + "]";
	}

	

	
	

}
