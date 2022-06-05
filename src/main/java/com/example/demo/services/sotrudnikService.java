package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Doljnost;
import com.example.demo.models.Sotrudnik;
import com.example.demo.repos.SotrudnikRepo;

@Service
public class sotrudnikService {
	private SotrudnikRepo sotrudnikrepos;
	public sotrudnikService(SotrudnikRepo sotr)
	{
		this.sotrudnikrepos=sotr;
	}
	public List<Sotrudnik>findsotrudnik()
	{
		return this.sotrudnikrepos.findAll();
	}
	public Sotrudnik findbysotrudnikid(int ks)
	{
		return this.sotrudnikrepos.findById(ks).get();
	}
	public void delsotrudnik(int ks)
	{
		this.sotrudnikrepos.deleteById(ks);
	}
	public void addsotrudnik(String fiop,String adresp,int okladp,String phonep,Doljnost doljnostp)
	{
		Sotrudnik sotrudnik=new Sotrudnik();
		sotrudnik.setAdres(adresp);
		sotrudnik.setFio(fiop);
		sotrudnik.setOklad(okladp);
		sotrudnik.setPhone(phonep);
		sotrudnik.setDoljnost(doljnostp);
		this.sotrudnikrepos.save(sotrudnik);

	}
	public void updatesotrudnik(int ks,String fiop,String adresp,int okladp,String phonep,Doljnost doljnostp)
	{
		Sotrudnik sotrudnik=this.sotrudnikrepos.findById(ks).get();
		sotrudnik.setAdres(adresp);
		sotrudnik.setFio(fiop);
		sotrudnik.setOklad(okladp);
		sotrudnik.setPhone(phonep);
		sotrudnik.setDoljnost(doljnostp);
		this.sotrudnikrepos.save(sotrudnik);
		
	}
}
