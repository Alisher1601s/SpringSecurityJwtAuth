package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class edinica {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
@OneToMany
private List<Syrie>syrie;
@OneToMany
private List<Product>product;
public void setProduct(List<Product>p)
{
	this.product=p;
}
public List<Product>getProduct()
{
	return product;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public void setId(int id)
{
	this.id=id;
}
public int getId()
{
	return id;
}
public List<Syrie>getSyrie()
{
	return syrie;
}
public void setSyrie(List<Syrie>ll)
{
	this.syrie=ll;
}
}
