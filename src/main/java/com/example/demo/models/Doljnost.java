package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Doljnost {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
@OneToMany
@JoinColumn(name="doljnostid")
private List<Sotrudnik> doljnost;
public List<Sotrudnik>getDoljnost()
{
	return doljnost;
}
public void setDoljnostList(List<Sotrudnik>dd)
{
	this.doljnost=dd;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
/*
<select  id="edin2" name="edin2">
<option value="">Select Syrie for disable</option>
<option th:each="taskk : ${syrie}"
        th:value="${taskk.getId()}"
        th:text="${taskk.getName()}">
</option>
</select>
*/