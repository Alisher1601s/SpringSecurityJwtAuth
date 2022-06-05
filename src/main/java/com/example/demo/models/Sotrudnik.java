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
public class Sotrudnik {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String fio;
private int oklad;
private String adres;
private String phone;
@OneToMany(mappedBy="sotrudnik")
private List<zarplata>listzarplata;
public List<zarplata> getzarplata()
{
	return this.listzarplata;
}
public void setListZarplata(List<zarplata>l)
{
	this.listzarplata=l;
}
@OneToMany(mappedBy="sotrudnik")
private List<ProdajaProdukcii>sotrudnik;
public List<ProdajaProdukcii> getsotrudnik()
{
	return sotrudnik;
}
public void setProdajaProducts(List<ProdajaProdukcii> t)
{
	this.sotrudnik=t;
}
@OneToMany
private List<ZakupkaSyria> zakupkasyriya;
public void setZakupkaSyria(List<ZakupkaSyria>l)
{
	this.zakupkasyriya=l;
}
@OneToMany(mappedBy="sotrudnik")
private List<Production>productionList;
public void setListProduction(List<Production>l)
{
	this.productionList=l;
}
public List<Production>getListProduction()
{
	return this.productionList;
}
public List<ZakupkaSyria>getZakupkaSyria()
{
	return this.zakupkasyriya;
}
@ManyToOne
@JoinColumn(name="doljnostid")
private Doljnost doljnost;
public Doljnost getDoljnost()
{
	return doljnost;
}
public void setDoljnost(Doljnost dolg)
{
	this.doljnost=dolg;
}
public String getAdres() {
	return adres;
}

public void setAdres(String adres) {
	this.adres = adres;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getOklad() {
	return oklad;
}
public void setOklad(int oklad) {
	this.oklad = oklad;
}
public String getFio() {
	return fio;
}
public void setFio(String fio) {
	this.fio = fio;
}
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id=id;
}
}
