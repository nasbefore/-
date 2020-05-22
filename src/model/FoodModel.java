package model;

import annotation.Column;
import annotation.ID;
import annotation.Table;

@Table(value="food_info")
public class FoodModel {
	@ID
	@Column(value="food_number")
	private String number;
	@Column(value="food_name")
	private String name;
	@Column(value ="food_amount")
	private int amount;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void getAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return number+","+name+","+amount;
	}
	
	
}
