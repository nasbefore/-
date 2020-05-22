package model;

import java.sql.Timestamp;

import annotation.Column;
import annotation.ID;
import annotation.Table;
@Table(value ="purchase")
public class Buymodel {
	@Column(value ="store_number")
	private String snumber;
	
	@ID
	@Column(value="food_number")
	private String number;
	@Column(value="food_name")
	private String name;
	
	@Column(value ="amount")
	private int amount;
	
	@Column(value ="price")
	private float price;
	
	@Column(value ="time")
	private Timestamp time;
	
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getFnumber() {
		return number;
	}
	public void setFnumber(String fnumber) {
		this.number = fnumber;
	}
	public String getFname() {
		return name;
	}
	public void setFname(String fname) {
		this.name = fname;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp Time) {
		time = Time;
	}
	@Override
	public String toString() {
		return snumber+","+number+","+name+","+amount+","+price+","+time;
	}
	
	
}
