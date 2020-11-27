package com.zoo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryType;
 
	@OneToMany(mappedBy = "category")
	private List<Animal> animalList;
	
	public Category(String categoryType) {
	
		this.categoryType = categoryType;
	}


	public Category() {
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}


	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryType=" + categoryType + "]";
	}
	
	
	
}
