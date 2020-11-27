package com.zoo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANIMAL")
public class Animal implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int anId;
	
	private String anType;
	private int anTotal;
	
	@OneToOne(mappedBy = "animal")
	private  Cage cage; 
	
	@ManyToOne
	@JoinColumn(name = "category_Id_FK")
	private Category category;
	
	@ManyToMany
	@JoinTable(name="animal_food_item",
	joinColumns= {@JoinColumn(name="animal_id",referencedColumnName="anId")},
	inverseJoinColumns= {@JoinColumn(name="food_item_id",referencedColumnName="foodId")})
	private List<FoodItem> fooditemList;
	
	public Animal() {
	}
	public Animal(String anType, int anTotal) {
		
		this.anType = anType;
		this.anTotal = anTotal;
	}
	public int getAnId() {
		return anId;
	}
	public void setAnId(int anId) {
		this.anId = anId;
	}
	public String getAnType() {
		return anType;
	}
	public void setAnType(String anType) {
		this.anType = anType;
	}
	public int getAnTotal() {
		return anTotal;
	}
	public void setAnTotal(int anTotal) {
		this.anTotal = anTotal;
	}
	@Override
	public String toString() {
		return "Animal [anId=" + anId + ", anType=" + anType + ", anTotal=" + anTotal + "]";
	}
	
	
	
	

	
	
}
