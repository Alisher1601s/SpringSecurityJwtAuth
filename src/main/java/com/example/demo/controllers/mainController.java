package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Budget;
import com.example.demo.models.Doljnost;
import com.example.demo.models.Product;
import com.example.demo.models.Sotrudnik;
import com.example.demo.models.Syrie;
import com.example.demo.models.edinica;
import com.example.demo.repos.*;
import com.example.demo.services.DoljnostService;
import com.example.demo.services.budgetService;
import com.example.demo.services.edinicaService;
import com.example.demo.services.sotrudnikService;
import com.example.demo.services.syrieService;

import javax.validation.Valid;

@Controller
public class mainController {
	private edinicaService edrepo;
	
	private DoljnostService dolg;
	private sotrudnikService sotrrepo;
	
	private syrieService syrierepo;
	
	private budgetService budgetrepos;
	
	@Autowired
	private IngredientsRepo IngredRepo;
	@Autowired
	private ProductRepo prodrepo;
	public mainController(DoljnostService dolg,edinicaService edrepo,syrieService syr,sotrudnikService sotr,budgetService bud)
	{
		this.dolg=dolg;
		this.edrepo=edrepo;
		this.syrierepo=syr;
		this.sotrrepo=sotr;
		this.budgetrepos=bud;
	}
@GetMapping("/budget")
public String getIndex(Model model)
{
	model.addAttribute("budgets",budgetrepos.findbudget());
	return "budgettt";
}

@PostMapping("/budget")
public String setBudget(@ModelAttribute("budg") Budget budg)
{
	
	this.budgetrepos.addbudget(budg.getBonus(), budg.getBudget(), budg.getPercent());
	return "redirect:/budget";
}
@GetMapping("/newbudget")
public String getnewBudget(@ModelAttribute("budget") Budget budg)
{
	return "new";
}
@GetMapping("/newedinica")
public String getnewEdinica(@ModelAttribute("edinicas")edinica ed)
{
		
	return "newedinica";
}
@PostMapping("/edinicaizmereniyas")
public String getNewEdd(@ModelAttribute("edinica") edinica ed)
{
	this.edrepo.addedinica(ed.getName());
	return "redirect:/edinicaizmereniyas";
}
@GetMapping("/edinicaizmereniyas")
public String getEd(Model model)
{

	
	
	
	 model.addAttribute("edinica",edrepo.finded());
	
	 
	 return "edinicaizm";
}
@GetMapping("/syriies")
public String getSyrie(Model model)
{
	model.addAttribute("syries",syrierepo.findsyrie());
	return "syriie";
}
@GetMapping("/syriies/{id}")
public String getId(@PathVariable("id") int id,Model model)
{
	model.addAttribute("syrieid",this.syrierepo.findbysyrieid(id));
	return "syrieid";
}
@GetMapping("/newsyriee")
public String getnewSyrie(Model model)
{
	
	model.addAttribute("edinica",this.edrepo.finded());
	return "newsyrie";
	
}
@PostMapping("/syriies")
public String getnewSyrr(@ModelAttribute("syrie") @Valid Syrie syrie, BindingResult bindingResult)
{
	if(bindingResult.hasErrors())
		return "redirect:/newsyrie";
	this.syrierepo.addsyrie(syrie.getName(), syrie.getSumma(), syrie.getKolvo(), syrie.getEdinica());
	
	return "redirect:/syriies";

}
@GetMapping("/products")

public String getProducts(Model model){

	model.addAttribute("prodd",prodrepo.findAll());
	return "prodd";
}
@GetMapping("/newproduct")
public String getNewProduct(@ModelAttribute("product") Product produc,Model model)
{
	
	model.addAttribute("edinica",this.edrepo.finded());
	return "newproductt";
}
@PostMapping("/products")
public String setNewProd(@ModelAttribute("product") Product prod)
{
	this.prodrepo.save(prod);
	return "redirect:/products";
}
@GetMapping("/Sotrudniki")
public String getSotrdunik(Model model)
{
	model.addAttribute("sotr",sotrrepo.findsotrudnik());
	
	return "sotrudniki";
}
@GetMapping("/budget/{id}")
public String getBudgetid(@PathVariable("id") int id,Model model)
{
	model.addAttribute("budget",this.budgetrepos.findbybudgetid(id));
	return "budgetid";
}
@GetMapping("/newSotrudnik")
public String getNewsotr(@ModelAttribute("sotrudnik") Sotrudnik sotr,Model model)
{
	
	model.addAttribute("doljnost",this.dolg.finddoljnost());
	return "newsotrudnik";
	
}
@PostMapping("/Sotrudniki")
public String getSotrd(@ModelAttribute("sotrudnik") Sotrudnik sotr)
{

	this.sotrrepo.addsotrudnik(sotr.getFio(), sotr.getAdres(), sotr.getOklad(), sotr.getPhone(), sotr.getDoljnost());
	
	
	
	return "redirect:/Sotrudniki";
	
	
}
@GetMapping("/Ingrediients")
public String getIngr(Model model)
{
	model.addAttribute("ingr",IngredRepo.findAll());
	return "Ingred";
}

@GetMapping("/doljnosti")
public String getDoljnosti(Model model)
{
	model.addAttribute("doljn",dolg.finddoljnost());
	
	return "doljnosti";
}
@GetMapping("/newdoljnost")
public String getNewDOljnost(@ModelAttribute("doljnost") Doljnost dolg)
{
	return "newdolgii";
}
@PostMapping("/doljnosti")
public String getDoljnostii(@ModelAttribute("doljnost") Doljnost dolgs)
{
	this.dolg.adddoljnost(dolgs.getName());
	return "redirect:/doljnosti";
}

}
