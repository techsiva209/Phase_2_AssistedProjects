package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Eproduct_27012022")
public class EProduct {

	@Id
	@GeneratedValue
	@Column(name="Eproduct_id")
	private int id;
	
	@Column(name="Eproduct_name")
	private String name;
	
	@Column(name="Eproduct_price")
	private Double price;

	
	//ALt + S + R
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}