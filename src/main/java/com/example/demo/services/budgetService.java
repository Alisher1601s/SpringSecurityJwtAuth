package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Budget;
import com.example.demo.repos.BudgetRepos;

@Service
public class budgetService {

	private final BudgetRepos budgetrepos;
	public budgetService(BudgetRepos budget)
	{
		this.budgetrepos=budget;
	}
	public List<Budget>findbudget()
	{
		return this.budgetrepos.findAll();
	}
	public void addbudget(double bon,double budget,double percent)
	{
	
		Budget budg=new Budget();
		budg.setBonus(bon);
		budg.setBudget(budget);
		budg.setPercent(percent);
		this.budgetrepos.save(budg);
	}
	public Budget findbybudgetid(int s)
	{
		return this.budgetrepos.findById(s).get();
	}
	public void updatebudget(int ks,double bon,double bud,double per)
	{
		Budget budg=this.budgetrepos.findById(ks).get();
		budg.setBonus(bon);
		budg.setBudget(bud);
		budg.setPercent(per);
		this.budgetrepos.save(budg);
		
	}
	public void delbudget(int ks)
	{
		this.budgetrepos.deleteById(ks);
	}
}
