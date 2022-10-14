package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pd")
public class Product 
{
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;
@Column(name = "name", nullable=false)
String name;
@Column(name = "cost", nullable=false)
float cost;
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
