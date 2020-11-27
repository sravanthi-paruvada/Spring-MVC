package com.zoo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class In_House_Vet extends Vet{

	private int salary;

	
	
	public In_House_Vet(String vetName, String vetQualification) {
		
	}

	public In_House_Vet(String vetName, String vetQualification, int salary) {
		super(vetName, vetQualification);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "In_House_Vet [salary=" + salary + "]";
	}
	
	
}
