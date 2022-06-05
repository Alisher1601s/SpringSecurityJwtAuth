package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProdajaProdukcii {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@ManyToOne
private Product product;
private int kolvo;
private double summa;
private LocalDate date;
@ManyToOne
private Sotrudnik sotrudnik;
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id=id;
}
public Sotrudnik getSotrudnik()
{
	return sotrudnik;
}
public void setSotrudnik(Sotrudnik s)
{
	this.sotrudnik=s;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public int getKolvo() {
	return kolvo;
}
public void setKolvo(int kolvo) {
	this.kolvo = kolvo;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public double getSumma() {
	return summa;
}
public void setSumma(double tt) {
	this.summa = tt;
}
}
