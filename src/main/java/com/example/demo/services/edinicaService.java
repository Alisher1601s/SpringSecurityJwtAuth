package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.edinica;
import com.example.demo.repos.edinicaRepo;
@Service
public class edinicaService {
	
	
	private final edinicaRepo edinicarepo;
	public edinicaService(edinicaRepo edrep)
	{
		this.edinicarepo=edrep;
	}
	public List<edinica>finded()
	{
		return this.edinicarepo.findAll();
	}
	public edinica findbyedid(int ks)
	{
		return this.edinicarepo.findById(ks).get();
	}
	public void deledinica(int ks)
	{
		this.edinicarepo.deleteById(ks);
	}
	public void addedinica(String edinicaname)
	{
		edinica edin=new edinica();
		edin.setName(edinicaname);
		this.edinicarepo.save(edin);
	}
	public void updateedinica(int ks,String edinicaname)
	{
		edinica edin=this.edinicarepo.findById(ks).get();
		edin.setName(edinicaname);
		this.edinicarepo.save(edin);
	}
}
