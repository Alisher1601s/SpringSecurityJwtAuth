package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ingredients  implements Comparable<Ingredients>{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private int kolvo;
@ManyToOne
@JoinColumn(name="syrieid")
private Syrie syrie;
public Syrie getSyrie()
{
	return syrie;
}
public void setSyrie(Syrie syrie)
{
	this.syrie=syrie;
}
@ManyToOne
@JoinColumn(name="productid")
private Product prod;
public void setProduct(Product pr)
{
	this.prod=pr;
}
public Product getProduct()
{
	return prod;
}
public int getKolvo() {
	return kolvo;
}
public void setKolvo(int kolvo) {
	this.kolvo = kolvo;
}
public void setId(int id)
{
	this.id=id;
}
public int getId()
{
	return id;
}
@Override
public int compareTo(Ingredients o) {
	// TODO Auto-generated method stub
	return Integer.compare(this.syrie.getId(), o.getSyrie().getId());
}
}
