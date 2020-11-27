package com.zoo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FOOD_ITEM")
public class FoodItem implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodId;
	
	private String foodName;
	private String foodquantity;
	
	@ManyToMany
	private List<Animal> animalList;
	
	@ManyToOne
	private Supplier supplier;
	
	
	public FoodItem( String foodName, String foodquantity) {
		
		this.foodName = foodName;
		this.foodquantity = foodquantity;
	}
	public FoodItem() {
		
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodquantity() {
		return foodquantity;
	}
	public void setFoodquantity(String foodquantity) {
		this.foodquantity = foodquantity;
	}
	@Override
	public String toString() {
		return "FoodItem [foodId=" + foodId + ", foodName=" + foodName + ", foodquantity=" + foodquantity + "]";
	}
	
	
	
	
	

}
