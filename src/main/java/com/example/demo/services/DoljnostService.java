package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Doljnost;
import com.example.demo.repos.DoljnostRepo;



@Service
public class DoljnostService{
	
private final DoljnostRepo doljnostrepos;

public DoljnostService(DoljnostRepo doljnostrepos)

{
	this.doljnostrepos=doljnostrepos;
}





public List<Doljnost>finddoljnost()
{
	return this.doljnostrepos.findAll();
}

public void deletedoljnost(int s)
{
	this.doljnostrepos.deleteById(s);
	
}
public Optional<Doljnost> findById(Integer s)
{
	return this.doljnostrepos.findById(s);
}
public void adddoljnost(String s)
{
	
	Doljnost doljnost=new Doljnost();
	doljnost.setName(s);
	this.doljnostrepos.save(doljnost);
}
public void updatedoljnost(String s,int s2)
{
	Doljnost doljnost=this.doljnostrepos.findById(s2).get();
	doljnost.setName(s);
	this.doljnostrepos.save(doljnost);
}
}
