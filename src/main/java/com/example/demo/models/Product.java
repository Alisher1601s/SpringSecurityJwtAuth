package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private double summa;
private int kolvo;
@OneToMany(mappedBy="product")
private List<ProdajaProdukcii>products;
public List<ProdajaProdukcii> getProducts()
{
	return products;
}
public void setProdajaProducts(List<ProdajaProdukcii> t)
{
	this.products=t;
}
@OneToMany(mappedBy="product")
private List<Production>productionList;
public void setListProduction(List<Production>l)
{
	this.productionList=l;
}
public List<Production>getListProduction()
{
	return this.productionList;
}
@OneToMany
@JoinColumn(name="productid")
private List<Ingredients>ingred;
public List<Ingredients>getIngredients()
{
	
	return ingred;
}
@ManyToOne
@JoinColumn(name="edinicaid")
private edinica edinica;
public edinica getEdinica()
{
	return edinica;
}
public void setEdinica(edinica ed)
{
	this.edinica=ed;
}
public void setIngredients(List<Ingredients>ll)
{
this.ingred=ll;	
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSumma() {
	return summa;
}
public void setSumma(double d) {
	this.summa = d;
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

}
