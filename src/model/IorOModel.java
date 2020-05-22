package model;

import java.sql.Timestamp;

import annotation.Column;
import annotation.ID;
import annotation.Table;
@Table(value ="inorout")
public class IorOModel {
	@Column(value ="food_number")
	private String fnumber;
	
	@Column(value ="status")
	private String s;
	@ID
	@Column(value ="amount")
	private int amount;
	@Column(value ="time")
	private Timestamp time;
	
	
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp Time) {
		time = Time;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return fnumber+","+s+","+amount+","+time;
	}
	
	
}
