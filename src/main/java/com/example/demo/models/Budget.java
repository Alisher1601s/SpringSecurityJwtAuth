package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
public class Budget {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private double bonus;
private double budget;

private double percent;
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id=id;
}
public double getBudget() {
	return budget;
}
public void setBudget(double tsk) {
	this.budget = tsk;
}
public double getPercent() {
	return percent;
}
public void setPercent(double percent) {
	this.percent = percent;
}
public double getBonus() {
	return bonus;
}
public void setBonus(double bonus) {
	this.bonus = bonus;
}

}
