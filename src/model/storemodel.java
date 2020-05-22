package model;

import annotation.Column;
import annotation.ID;
import annotation.Table;

@Table(value="store_info")
public class storemodel {
	@ID
	@Column(value="store_number")
	private String number;
	@Column(value="store_name")
	private String name;

	
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

	@Override
	public String toString() {
		return number+","+name;
	}
	
}