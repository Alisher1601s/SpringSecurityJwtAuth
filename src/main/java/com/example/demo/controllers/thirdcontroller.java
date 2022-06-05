package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.ProdajaProdukcii;
import com.example.demo.models.Production;
import com.example.demo.models.Sotrudnik;
import com.example.demo.models.ZakupkaSyria;
import com.example.demo.models.zarplata;
import com.example.demo.repos.BudgetRepos;
import com.example.demo.repos.ProdajaProdRepo;
import com.example.demo.repos.ProductionRepo;
import com.example.demo.repos.SotrudnikRepo;
import com.example.demo.repos.ZakupkaRepos;
import com.example.demo.repos.ZarplataRepos;

@Controller
public class thirdcontroller {
	@Autowired
	private ZarplataRepos zarplatarepos;
	@Autowired
	private ZakupkaRepos zakupkasyrca;
	@Autowired
	private ProdajaProdRepo prodaja;
	@Autowired
	private ProductionRepo production;
	@Autowired
	private SotrudnikRepo sotrudnikrepo;
	@Autowired
	private BudgetRepos budget;
@GetMapping("/zarplatak")
public String getFiltrZarplata(Model model,@ModelAttribute("zarplata") zarplata zp)
{

	
	List<zarplata>zpk=this.zarplatarepos.findAll();
	List<zarplata>zpk2=new ArrayList<>();	
	for(int i=0;i!=zpk.size();++i)
	{
		if(zpk.get(i).getYear()==zp.getYear() && zpk.get(i).getMounth()==zp.getMounth())
		{
			zpk2.add(zpk.get(i));
		}
	}
	if(zpk2.size()!=0)
	{
		
		model.addAttribute("zarplatas",zpk2);
	}
	return "zarplata";
}
@PostMapping("/zarplatak")
public void addD(Model model,@ModelAttribute("zarplata") zarplata zp)
{
	int year=zp.getYear();
	int mounth=zp.getMounth();
	List<ZakupkaSyria>zakupkalist=this.zakupkasyrca.findAll();
	List<ProdajaProdukcii>listprodaja=this.prodaja.findAll();
	List<Production>listproduction=this.production.findAll();
	List<ZakupkaSyria>zakupkalist2=new ArrayList();
	List<ProdajaProdukcii>listprodaja2=new ArrayList();
	List<Production>listproduction2=new ArrayList();
	for(int i=0;i!=zakupkalist.size();++i)
	{
		if(year==zakupkalist.get(i).getDate().getYear() && mounth==zakupkalist.get(i).getDate().getMonthValue())
		{
			zakupkalist2.add(zakupkalist.get(i));
			
			
		}
	}
	for(int i=0;i!=listproduction.size();++i)
	{
		if(year==listproduction.get(i).getDate().getYear() && mounth==listproduction.get(i).getDate().getMonthValue())
		{
			listproduction2.add(listproduction.get(i));
		}
	}
	for(int i=0;i!=listprodaja.size();++i)
	{
		if(year==listprodaja.get(i).getDate().getYear() && mounth==listprodaja.get(i).getDate().getMonthValue())
		{
			listprodaja2.add(listprodaja.get(i));
		}
	}
	List<Sotrudnik>listsotrdunik=this.sotrudnikrepo.findAll();
	
	for(int i=0;i!=listsotrdunik.size();++i)
	{

		
		double bonus=listsotrdunik.get(i).getOklad()/100*this.budget.getById(1).getBonus();
		
		
// percent		double bonus=this.budget.getById(1).getPercent()
		int count_purchase=0;
		
		for(int j=0;j!=zakupkalist2.size();++j)
		{
			if(listsotrdunik.get(i).getFio().equals(zakupkalist2.get(i).getSotrudnik().getFio()))
				++count_purchase;
			
		}
		int count_prodaja=0;
		for(int j=0;j!=listprodaja2.size();++j)
		{
			if(listsotrdunik.get(i).getFio().equals(listprodaja2.get(i).getSotrudnik().getFio()))
				++count_prodaja;
			
		}
		int count_production=0;
		for(int j=0;j!=listproduction2.size();++j)
		{
			if(listsotrdunik.get(i).getFio().equals(listproduction2.get(i).getSotrudnik().getFio()))
				++count_production;
			
		}
		zarplata newzp=new zarplata();
		newzp.setFio(listsotrdunik.get(i).getFio());
		newzp.setYear(year);
		newzp.setMounth(mounth);
		newzp.setSotrudnik(listsotrdunik.get(i));
		newzp.setKolvozakupka(count_purchase);
		newzp.setKolvoprodaja(count_prodaja);
		newzp.setKolvoproiz(count_production);
		newzp.setObweeuchastie(count_production+count_prodaja+count_purchase);
		newzp.setOklad(listsotrdunik.get(i).getOklad());
		double oklads=listsotrdunik.get(i).getOklad()+(bonus*(count_production+count_prodaja+count_purchase));
		newzp.setSummabonusa(oklads);
		this.zarplatarepos.save(newzp);
	}
	
}
@GetMapping("/sozdaniezp")
public String sozdanie(Model model,@ModelAttribute("zarplata") zarplata zp)
{
	model.addAttribute("zarplatas",this.zarplatarepos.findAll());
	return "zarplata3";
}
@PostMapping("/zarplatak2")
public String oplata(@ModelAttribute("zarplata") zarplata zp)
{
	List<zarplata>zpk=this.zarplatarepos.findAll();
	List<zarplata>zpk2=new ArrayList<>();	
	for(int i=0;i!=zpk.size();++i)
	{
		if(zpk.get(i).getYear()==zp.getYear() && zpk.get(i).getMounth()==zp.getMounth())
		{
			zpk2.add(zpk.get(i));
		}
	}
	double sum=0;
	for(int i=0;i!=zpk2.size();++i)
	{
		sum+=zpk2.get(i).getOklad();
	}
	if(this.budget.getById(1).getBudget()-sum<0)
	{
		System.out.println("Выдать нельзя!");
		return "";
	}
	for(int i=0;i!=zpk2.size();++i)
	{
		if(zpk2.get(i).isGiven()==false)
		{
			if(this.budget.getById(1).getBudget()-sum>0)
			{
				this.budget.getById(1).setBudget(this.budget.getById(1).getBudget()-zpk2.get(i).getOklad());
			zpk2.get(i).setGiven(true);	
			}
		}
	}
	
	
	
	return "redirect:/zarplatak";
}
}
