package model;

import annotation.Column;
import annotation.ID;
import annotation.Table;

@Table(value="price")
public class pricemodel {
	@ID
	@Column(value="food_number")
	private String number;
	@Column(value="store_number")
	private String number1;
	@Column(value ="price")
	private float price;
	
	public String getFNumber() {
		return number;
	}
	public void setFNumber(String fnumber) {
		this.number = fnumber;
	}
	public String getSnumber() {
		return number1;
	}
	public void setSnumber(String snumber) {
		this.number1 = snumber;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return number+","+number1+","+price;
	}
	
}
