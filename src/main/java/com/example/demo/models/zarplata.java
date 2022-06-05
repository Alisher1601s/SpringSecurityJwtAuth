package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class zarplata {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(unique=true)
private int year;
@Column(unique=true)
private int mounth;
private String fio;
@ManyToOne
private Sotrudnik sotrudnik;
public Sotrudnik getSotrudnik()
{
	return this.sotrudnik;
}
public void setSotrudnik(Sotrudnik sotr)
{
	this.sotrudnik=sotr;
}
private int kolvozakupka;
private int kolvoprodaja;
private int kolvoproiz;
private int oklad;
private double summabonusa;
private boolean isGiven=false;
private int obweeuchastie;
public int getKolvoprodaja() {
	return kolvoprodaja;
}
public void setKolvoprodaja(int kolvoprodaja) {
	this.kolvoprodaja = kolvoprodaja;
}
public int getKolvoproiz() {
	return kolvoproiz;
}
public void setKolvoproiz(int kolvoproiz) {
	this.kolvoproiz = kolvoproiz;
}
public int getOklad() {
	return oklad;
}
public void setOklad(int oklad) {
	this.oklad = oklad;
}
public int getObweeuchastie() {
	return obweeuchastie;
}
public void setObweeuchastie(int obweeuchastie) {
	this.obweeuchastie = obweeuchastie;
}
public double getSummabonusa() {
	return summabonusa;
}
public void setSummabonusa(double summabonusa) {
	this.summabonusa = summabonusa;
}
public String getFio() {
	return fio;
}
public void setFio(String fio) {
	this.fio = fio;
}
public int getMounth() {
	return mounth;
}
public void setMounth(int mounth) {
	this.mounth = mounth;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getKolvozakupka() {
	return kolvozakupka;
}
public void setKolvozakupka(int kolvozakupka) {
	this.kolvozakupka = kolvozakupka;
}

public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id=id;
}
public boolean isGiven() {
	return isGiven;
}
public void setGiven(boolean isGiven) {
	this.isGiven = isGiven;
}


}
