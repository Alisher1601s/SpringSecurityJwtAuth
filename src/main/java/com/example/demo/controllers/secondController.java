package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.example.demo.models.ProdajaProdukcii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Budget;
import com.example.demo.models.Doljnost;
import com.example.demo.models.Ingredients;
import com.example.demo.models.Product;
import com.example.demo.models.Production;
import com.example.demo.models.Sotrudnik;
import com.example.demo.models.Syrie;
import com.example.demo.models.ZakupkaSyria;
import com.example.demo.models.edinica;
import com.example.demo.repos.BudgetRepos;
import com.example.demo.repos.DoljnostRepo;
import com.example.demo.repos.IngredientsRepo;
import com.example.demo.repos.ProdajaProdRepo;
import com.example.demo.repos.ProductRepo;
import com.example.demo.repos.ProductionRepo;
import com.example.demo.repos.SotrudnikRepo;
import com.example.demo.repos.SyrieRepo;
import com.example.demo.repos.ZakupkaRepos;
import com.example.demo.repos.edinicaRepo;
import com.example.demo.services.DoljnostService;
import com.example.demo.services.budgetService;
import com.example.demo.services.edinicaService;
import com.example.demo.services.sotrudnikService;
import com.example.demo.services.syrieService;

import net.bytebuddy.asm.Advice.This;

@Controller
public class secondController {

	@Autowired
	private ProdajaProdRepo prodajaprodukcii;
	@Autowired
	private IngredientsRepo IngredRepo;
	private sotrudnikService sotrrepo;
	private edinicaService edrepo;
	
	private DoljnostService dolg;
	
	
	
	private syrieService syrierepo;
	private budgetService budgetrepos;
	@Autowired
	private ZakupkaRepos zpk;
	

	@Autowired
	private ProductRepo prodrepo;
	
	public secondController(DoljnostService dolg,edinicaService edr,budgetService budg,sotrudnikService sotr,syrieService syr)
	{
		this.dolg=dolg;
		this.edrepo=edr;
		this.syrierepo=syr;
		this.sotrrepo=sotr;
		this.budgetrepos=budg;
	}
	
	
	@Autowired
	private ProductionRepo productionRepo;
	@GetMapping("/doljnosti/{id}")
	public String getDoljnid(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("dolgid",this.dolg.findById(id).get());
		return "doljnostid";
	}
	@GetMapping("/edinicaizmereniyas/{id}")
	public String getEdinicaId(@PathVariable("id") int id,Model model)
	{
		
		model.addAttribute("edinica",edrepo.findbyedid(id));
		return "edinicaid";
		
	}
	@GetMapping("/Ingrediients/{id}")
	public String getIngredId(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("ingred",this.IngredRepo.findById(id).get());
	//	model.addAttribute("product",this.syrierepo.findAllById(this.IngredRepo.findById(id).get().getProduct().getId()));
		
		return "ingredid";
	}
	@GetMapping("/Ingrediients/{id}/edit")
	public String edittIngred(Model model,@PathVariable("id") int id)
	{
		model.addAttribute("ingred",this.IngredRepo.findById(id).get());
		model.addAttribute("product",this.prodrepo.findAll());
		model.addAttribute("syrie",this.syrierepo.findsyrie());
		return "editIngred";
	}
	
	@PatchMapping("Ingrediients/{id}")
	public String editIngr(@PathVariable("id") int id,@ModelAttribute("ingred") Ingredients ingredient){
		
		Ingredients str=this.IngredRepo.findById(id).get();
		str.setId(ingredient.getId());
		str.setKolvo(ingredient.getKolvo());
		str.setProduct(ingredient.getProduct());
		str.setSyrie(ingredient.getSyrie());
		this.IngredRepo.save(str);
		return "redirect:/Ingrediients";
	}
	
	@GetMapping("/products/{id}")
	public String getProdId(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("prod",this.prodrepo.findById(id).get());
		return "prodid";
	}
	
	@GetMapping("/Sotrudniki/{id}")
	public String getSotrid(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("sotr",this.sotrrepo.findbysotrudnikid(id));
		return "sotrid";
	}
	@GetMapping("/budget/{id}/edit")
	public String edit(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("budgets",
				this.budgetrepos.findbybudgetid(id));
		return "edit";
	}
	@PatchMapping("/budget/{id}")
	public String editBudget(@ModelAttribute("budget") Budget budget,@PathVariable("id") int id)
	{
		

		this.budgetrepos.updatebudget(id, budget.getBonus(), budget.getBudget(), budget.getPercent());
		return "redirect:/budget";
	}
	@GetMapping("/doljnosti/{id}/edit")
	public String editDolj(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("doljnost",this.dolg.findById(id).get());
		return "editDoljnost";
	}
	@PatchMapping("/doljnosti/{id}")
	public String editDoljj(@ModelAttribute("doljnost") Doljnost doljnost,@PathVariable("id") int id)
	{
	
	
		this.dolg.updatedoljnost(doljnost.getName(), id);
		return "redirect:/doljnosti";
	}
	@GetMapping("/edinicaizmereniyas/{id}/edit")
	public String editEdinica(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("edinica",this.edrepo.findbyedid(id));
		return "editedinica";
	}
	@PatchMapping("/edinicaizmereniyas/{id}")
	public String editEdi(@ModelAttribute("edinica") edinica ed,@PathVariable("id") int id)
	{
		this.edrepo.updateedinica(id,ed.getName());
		return "redirect:/edinicaizmereniyas";
	}
	@GetMapping("/products/{id}/edit")
	public String editProduct(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("product",this.prodrepo.findById(id).get());
		model.addAttribute("edinica",this.edrepo.finded());
		return "editProduct";
	}
	@PatchMapping("/products/{id}")
	public String editProd(@PathVariable("id") int id,@ModelAttribute("product") Product pr)
	{
	
		Product pp=this.prodrepo.findById(id).get();
		pp.setEdinica(pr.getEdinica());
		pp.setKolvo(pr.getKolvo());
		pp.setName(pr.getName());
		pp.setSumma(pr.getSumma());
		this.prodrepo.save(pp);
		return "redirect:/products";
	}
	@GetMapping("Sotrudniki/{id}/edit")
	public String editSotrUdnik(@PathVariable("id") int id,Model model)
	{
		model.addAttribute("sotrudnik",this.sotrrepo.findbysotrudnikid(id));
		model.addAttribute("doljnost",this.dolg.finddoljnost());
		return "editSotrudnik";
	}
	@PatchMapping("Sotrudniki/{id}")
	public String editSotr(@PathVariable("id") int id, @ModelAttribute("sotrudnik")  Sotrudnik sotr)
	{

		this.sotrrepo.updatesotrudnik(id, sotr.getFio(), sotr.getAdres(), sotr.getOklad(), sotr.getPhone(), sotr.getDoljnost());
		return "redirect:/Sotrudniki";
	}
	@GetMapping("/syriies/{id}/edit")
	public String editSyrie(@PathVariable("id") int id,Model model)
	{

		model.addAttribute("syrie",this.syrierepo.findbysyrieid(id));
		model.addAttribute("edinica",this.edrepo.finded());
		return "editSyrie";
	}
	@GetMapping("/Ingrediients/new")
	public String addIngr(@ModelAttribute("ingred") Ingredients ingrr,Model model)
	{
		model.addAttribute("syrie",this.syrierepo.findsyrie());
		model.addAttribute("product",this.prodrepo.findAll());
		return "newIngr";
	}
	@PostMapping("/Ingrediients")
	public String addIngred(@ModelAttribute("ingred") Ingredients ingrr)
	{
		this.IngredRepo.save(ingrr);
		return "redirect:/Ingrediients";
	}
	@PatchMapping("/syriies/{id}")
	public String editSyr(@PathVariable("id") int id,@ModelAttribute("syrie") @Valid Syrie syr,BindingResult bindingResult)
	{

		if(bindingResult.hasErrors())
		{
			System.out.println(bindingResult.getFieldError());
			return "redirect:/syriies/{id}/edit";
		}
		this.syrierepo.updatesyrie(id, syr.getName(), syr.getSumma(), syr.getKolvo(), syr.getEdinica());
		return "redirect:/syriies";
	}
	@GetMapping("/zakupkaSyria")
	public String getSyrie(Model model)
	{
		model.addAttribute("zakupka",this.zpk.findAll());
		return "zakupkasyr";
		
	}
	@GetMapping("/ProdajaProdukcii/new")
	public String getProdaja(@ModelAttribute("prodajaprodukcii") ProdajaProdukcii prod,Model model)
	{
		model.addAttribute("sotrudnik",this.sotrrepo.findsotrudnik());
		model.addAttribute("products",this.prodrepo.findAll());
		model.addAttribute("chislo",0);
		return "newProdajaProdukcii";
	}
	@PostMapping("/ProdajaProdukcii")
	public String addProductProdaja(@ModelAttribute("prodajaprodukcii") ProdajaProdukcii prod)
	{
		
		Product pr=this.prodrepo.findById(prod.getProduct().getId()).get();
		if(prod.getKolvo()<=pr.getKolvo())
		{
			double seb= (pr.getSumma()/pr.getKolvo());
			Budget t=this.budgetrepos.findbybudgetid(1);
		//	double tsk=100-(((((double)pr.getSumma()/pr.getKolvo())*prod.getKolvo())/prod.getSumma())*100);
			double tsk=((seb*prod.getKolvo())/100)*t.getPercent()+seb*prod.getKolvo();
			prod.setSumma(tsk);
			t.setBudget(t.getBudget()+tsk);
			
			this.budgetrepos.addbudget(t.getBonus(), t.getBudget(), t.getPercent());
			pr.setKolvo(pr.getKolvo()-prod.getKolvo());
			pr.setSumma(pr.getSumma()-seb*prod.getKolvo());
			this.prodrepo.save(pr);
			this.prodajaprodukcii.save(prod);
		}
		else
		{
		return "err";
		}
		
		return "redirect:/ProdajaProdukcii";
	}
	@GetMapping("/zakupkaSyria/new")
	public String getSyrie(@ModelAttribute("zakupka") ZakupkaSyria zp,Model model)
	{
		
		model.addAttribute("sotrudnik",this.sotrrepo.findsotrudnik());
		model.addAttribute("syrie",this.syrierepo.findsyrie());
		
	return "newZakupka";
	}
	@GetMapping("/editZakupkaSyria/{id}")
	public String editSyrie(@PathVariable("id") int id,@ModelAttribute("zakupka") ZakupkaSyria zp,Model model)
	{
		
		model.addAttribute("sotrudnik",this.sotrrepo.findsotrudnik());
		model.addAttribute("syrie",this.syrierepo.findsyrie());
		return "editZakupka";
	}
	@PostMapping("/zakupkaSyria")
	public String addSyria(@ModelAttribute("zakupka") ZakupkaSyria zp,Model model)
	{
		Syrie syr=this.syrierepo.findbysyrieid(zp.getSyrie().getId());
		
		Budget t=this.budgetrepos.findbybudgetid(1);
		
		if(t.getBudget()>=zp.getSumma())
		{
		
			syr.setSumma(syr.getSumma()+zp.getSumma());
			syr.setKolvo(syr.getKolvo()+zp.getKolvo());
			t.setBudget(t.getBudget()-zp.getSumma());
			this.syrierepo.addsyrie(syr.getName(), syr.getSumma(), syr.getKolvo(), syr.getEdinica());
			this.budgetrepos.addbudget(t.getBonus(), t.getBudget(), t.getPercent());
			this.zpk.save(zp);
		}
		else
		{

		return "err";
		}
		
		return "redirect:/zakupkaSyria";
	}

	@PatchMapping("/zakupkaSyria/{id}")
	public String editZakupkaSyria(@PathVariable("id") int id, @ModelAttribute("zakupka") ZakupkaSyria zp)
	{
		
		Syrie syr=this.syrierepo.findbysyrieid(zp.getSyrie().getId());
		
		var staroekolvo=syr.getKolvo();
		var novoekolvo=zp.getKolvo();
		var raznica=novoekolvo-staroekolvo;
		syr.setKolvo(zp.getKolvo()-syr.getKolvo());
		var staroesumma=syr.getSumma();
		var novoesumma=zp.getSumma();
		var raznicasummy=novoesumma-staroesumma;
		

		Budget t=this.budgetrepos.findbybudgetid(1);
		
	
		if(t.getBudget()-raznicasummy>=0)
		{
		
			syr.setSumma(syr.getSumma()+raznicasummy);
			syr.setKolvo(syr.getKolvo()+raznica);
			t.setBudget(t.getBudget()-raznicasummy);
			this.syrierepo.addsyrie(syr.getName(), syr.getSumma(), syr.getKolvo(), syr.getEdinica());
			this.budgetrepos.addbudget(t.getBonus(),t.getBudget(), t.getPercent());
			this.zpk.save(zp);
		}
		else
		{

		return "err";
		}
		

		
		return "redirect:/zapukaSyria";
		
	}

	@GetMapping("/zakupkaSyria/{id}")
	public String getZakupkaSyriaId(@PathVariable("id") int id,Model model)
	{
		
		model.addAttribute("zakupka",this.zpk.findById(id).get());
		return "zakupkaid";
		
	}
	
	@GetMapping("/main")
	public String MainPage(Model model)
	{

		
		model.addAttribute("budgets",this.budgetrepos.findbudget());
		model.addAttribute("doljn",this.dolg.finddoljnost());
		model.addAttribute("sotr",this.sotrrepo.findsotrudnik());
		model.addAttribute("syries",this.syrierepo.findsyrie());
		model.addAttribute("edinica",this.edrepo.finded());
		model.addAttribute("ingr",this.IngredRepo.findAll());
		model.addAttribute("prodd",this.prodrepo.findAll());
		model.addAttribute("zakupka",this.zpk.findAll());
		model.addAttribute("prodajaproducts",this.prodajaprodukcii.findAll());
		model.addAttribute("production",this.productionRepo.findAll());
		return "main";
	}
	@DeleteMapping("/syriies/{id}")
	public String delSyrie(@PathVariable("id") int id)
	{
		this.syrierepo.delsyrie(id);
		return "redirect:/syriies";
		
	}
	@DeleteMapping("/Sotrudniki/{id}")
	public String delSotr(@PathVariable("id") int id)
	{
		this.sotrrepo.delsotrudnik(id);
		return "redirect:/Sotrudniki";
	}
@DeleteMapping("/doljnosti/{id}")
	public String delDolj(@PathVariable("id") int id)
	{
		this.dolg.deletedoljnost(id);
		return "redirect:/doljnosti";
	}
	@DeleteMapping("/edinicaizmereniyas/{id}")
	@Transactional
	public String delEd(@PathVariable("id") int id)
	{
		this.edrepo.deledinica(id);
		return "redirect:/edinicaizmereniyas";
	}
	@DeleteMapping("/products/{id}")
	public String delProd(@PathVariable("id") int id)
	{
		this.prodrepo.deleteById(id);
		return "redirect:/products";
	}
	@DeleteMapping("/Ingrediients/{id}")
	public String delIngred(@PathVariable("id") int id)
	{
		this.IngredRepo.deleteById(id);
		return "redirect:/Ingrediients";
	}
	@GetMapping("/ProdajaProdukcii")
	public String showSellProducts(Model model)
	{
		model.addAttribute("prodajaproducts",this.prodajaprodukcii.findAll());
		return "prodajaprod";
	}
	@GetMapping("/filter")
	public String showFilter(Model model,@ModelAttribute("budgets") Ingredients prod)
	{
	
		
		model.addAttribute("product",this.prodrepo.findAll());
		return "filter";
	}
	
	@GetMapping("/filter/{id}")
	public String showListSyrie(@ModelAttribute("budgets") Ingredients prod,Model model)
	{
		List<Syrie>syrie=new ArrayList<Syrie>();
		boolean flag=false;
		List<Ingredients> list=this.IngredRepo.findAll();
		for(int i=0;i!=list.size();++i)
		{
		if(list.get(i).getProduct().getId()==prod.getProduct().getId())
		{
			syrie.add(list.get(i).getSyrie());
			flag=true;
		}
		}
		model.addAttribute("syries",syrie);
		if(flag==false)
			model.addAttribute("flag",flag);
		return "filter2";
	}
	@GetMapping("/production")
	public String showProductionList(Model model)
	{
		model.addAttribute("production",this.productionRepo.findAll());
		return "production";
	}
	@GetMapping("/production/new")
	public String addProduction(@ModelAttribute("production") Production production,Model model)
	{
	
		model.addAttribute("sotrudnik",this.sotrrepo.findsotrudnik());
		model.addAttribute("products",this.prodrepo.findAll());
		return "newProduction";
	}
	@PostMapping("/production")
	public String addProduct(@ModelAttribute("production") Production production)
	{
		
		List<Ingredients>ingredients=this.IngredRepo.findAll();
		List<Ingredients>ingredients2=new ArrayList<Ingredients>();
		for(int i=0;i!=ingredients.size();++i)
		{
			if(ingredients.get(i).getProduct().getId()==production.getProduct().getId())
			{
				ingredients2.add(ingredients.get(i));
			}
		}
		List<Syrie>syrie=this.syrierepo.findsyrie();
		List<Syrie>syrie2=new ArrayList<Syrie>();
		Collections.sort(ingredients2);
		Collections.sort(syrie);
		for(int i=0;i!=ingredients2.size();++i)
		{
			System.out.println(ingredients2.get(i).getSyrie().getId());
		}
		for(int i=0;i!=syrie.size();++i)
		{
			if(syrie.get(i).getId()==ingredients2.get(i).getSyrie().getId())
			{
				syrie2.add(syrie.get(i));
			}
		}
		
		for(int i=0;i!=syrie2.size();++i)
		{
			if(syrie2.get(i).getId()==ingredients2.get(i).getSyrie().getId())
			{
			

				if(ingredients2.get(i).getKolvo()*production.getKolvo()>syrie2.get(i).getKolvo()*production.getKolvo() ||
						syrie2.get(i).getKolvo()-production.getKolvo()*ingredients2.get(i).getKolvo()<=0)
				{
					return "err3";
				}
			}
		}
		double sum=0;
		for(int i=0;i!=syrie2.size();++i)
		{
			if(syrie2.get(i).getId()==ingredients2.get(i).getSyrie().getId())
			{
				double sebes=(double) (syrie.get(i).getSumma()/syrie.get(i).getKolvo());
				System.out.println("SEBESTOIMOST" + sebes);
				double countofsyrie=ingredients2.get(i).getKolvo()*production.getKolvo();
				double summaofsyrie=sebes*production.getKolvo()*ingredients2.get(i).getKolvo();
				sum+=summaofsyrie;
				System.out.println("Count OF NUJNOGO SYRIA " +countofsyrie);
				System.out.println("SUMMA SYRIA " + summaofsyrie);
				
				syrie.get(i).setSumma(syrie.get(i).getSumma()-summaofsyrie);

				syrie.get(i).setKolvo(syrie.get(i).getKolvo()-countofsyrie);
				this.syrierepo.addsyrie(syrie.get(i).getName(), syrie.get(i).getSumma(),syrie.get(i).getKolvo(),syrie.get(i).getEdinica());
		
				
			}
		}
		Product product=this.prodrepo.findById(production.getProduct().getId()).get();
		System.out.println("SUM " + sum);
		product.setSumma(product.getSumma()+sum);
		product.setKolvo(product.getKolvo()+production.getKolvo());
		this.prodrepo.save(product);
		this.productionRepo.save(production);
		return "redirect:/production";
		
	}
}
