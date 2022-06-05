package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ZakupkaSyria {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@ManyToOne
@JoinColumn(name="sotrudnikid")
private Sotrudnik sotrudnik;
@ManyToOne
@JoinColumn(name="syrieid")
private Syrie syrie;
private LocalDate date;
private int summa;
private int kolvo;
public int getSumma() {
	return summa;
}
public void setSumma(int summa) {
	this.summa = summa;
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
public void setSotrudnik(Sotrudnik sotr)
{
	this.sotrudnik=sotr;
}
public Sotrudnik getSotrudnik()
{
	return sotrudnik;
}
public void setSyrie(Syrie sr)
{
	this.syrie=sr;
}
public Syrie getSyrie()
{
	return syrie;
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
