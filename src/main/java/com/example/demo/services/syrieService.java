package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Syrie;
import com.example.demo.models.edinica;
import com.example.demo.repos.SyrieRepo;

@Service
public class syrieService {
	private final SyrieRepo syrierepos;
	public syrieService(SyrieRepo syrie)
	{
		this.syrierepos=syrie;
	}
	
	public List<Syrie>findsyrie()
	{
		return this.syrierepos.findAll();
	}
	public Syrie findbysyrieid(int ks)
	{
		return this.syrierepos.findById(ks).get();
	}
	public void delsyrie(int ks)
	{
		this.syrierepos.deleteById(ks);
	}
	public void addsyrie(String namep,double summap,double kolvop,edinica edinicap)
	{
		Syrie syrie=new Syrie();
		syrie.setEdinica(edinicap);
		syrie.setKolvo(kolvop);
		syrie.setName(namep);
		syrie.setSumma(summap);
		this.syrierepos.save(syrie);
	}
	public void updatesyrie(int ks,String namep,double summap,double kolvop,edinica edinicap)
	{
		Syrie syrie=this.syrierepos.findById(ks).get();
		syrie.setEdinica(edinicap);
		syrie.setKolvo(kolvop);
		syrie.setName(namep);
		syrie.setSumma(summap);
		this.syrierepos.save(syrie);
	}
}
