package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Production {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@ManyToOne
@JoinColumn(name="productid")
private Product product;
private int kolvo;
private int summa;
private LocalDate date;
@ManyToOne
@JoinColumn(name="sotrudnikid")
private Sotrudnik sotrudnik;
public int getKolvo() {
	return kolvo;
}
public void setKolvo(int kolvo) {
	this.kolvo = kolvo;
}
public int getSumma() {
	return summa;
}
public void setSumma(int summa) {
	this.summa = summa;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id=id;
}
public Product getProduct()
{
	return product;
}
public void setProduct(Product product)
{
	this.product=product;
}
public Sotrudnik getSotrudnik()
{
	return this.sotrudnik;
}
public void setSotrudnik(Sotrudnik sotrudnik)
{
	this.sotrudnik=sotrudnik;
}

}
