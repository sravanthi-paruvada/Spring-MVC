package com.zoo;

import javax.persistence.*;

@Entity
@Table(name = "STAFF")
public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int staffid;
	private String name;
	private String salary;
	private int age;
	private String gender;
	
	public Staff() {
		
		// TODO Auto-generated constructor stub
	}
	public Staff(String name, String salary, int age, String gender) {
		
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.gender = gender;
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Staff [staffid=" + staffid + ", name=" + name + ", salary=" + salary + ", age=" + age + ", gender="
				+ gender + "]";
	}
	
	
}
