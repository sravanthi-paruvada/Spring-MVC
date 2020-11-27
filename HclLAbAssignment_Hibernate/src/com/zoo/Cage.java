package com.zoo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CAGE")
public class Cage implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cageid;
	
	private String cageNo;
	private String cageLocation;
	
	@OneToOne
	@JoinColumn(name="anId_FK")
	private Animal animal;

	public Cage( String cageNo, String cageLocation) {
		
		this.cageNo = cageNo;
		this.cageLocation = cageLocation;
	}

	
	public int getCageid() {
		return cageid;
	}

	public void setCageid(int cageid) {
		this.cageid = cageid;
	}

	public String getCageNo() {
		return cageNo;
	}

	public void setCageNo(String cageNo) {
		this.cageNo = cageNo;
	}

	public String getCageLocation() {
		return cageLocation;
	}

	public void setCageLocation(String cageLocation) {
		this.cageLocation = cageLocation;
	}

	public Cage() {
	}
	
	
	@Override
	public String toString() {
		return "Cage [cageid=" + cageid + ", cageNo=" + cageNo + ", cageLocation=" + cageLocation + "]";
	}

	
}
