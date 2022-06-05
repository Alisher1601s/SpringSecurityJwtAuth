package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.Budget;
import com.example.demo.models.Syrie;
import com.example.demo.services.budgetService;
import com.example.demo.models.ZakupkaSyria;
import com.example.demo.repos.ZakupkaRepos;

@Service
public class ZakupkaSyriaService {
private final ZakupkaRepos zakupkaSyria;
private final budgetService budgetService;
private final syrieService syrieserv;
public ZakupkaSyriaService(ZakupkaRepos zpk,syrieService syr,budgetService bud)
{
	this.zakupkaSyria=zpk;
	this.syrieserv=syr;
	this.budgetService=bud;
}
public boolean zakupka(int syrieid)
{
	Syrie syr=this.syrieserv.findbysyrieid(syrieid);
	Budget budget=this.budgetService.findbybudgetid(1);
	if(budget.getBudget()<syr.getSumma())
	{
		return false;
	}
	else
		return false;
}

}
