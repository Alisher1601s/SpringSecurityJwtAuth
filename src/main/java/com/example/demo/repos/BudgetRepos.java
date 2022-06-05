package com.example.demo.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Budget;
@Repository
public interface BudgetRepos extends JpaRepository<Budget,Integer>{

	@Procedure
	List<Budget>findbudget();
	@Procedure
	Budget findbybudgetid(int ks);
	@Procedure
	void updatebudget(int ks,double bon,double bud,double per);
	@Procedure
	void delbudget(int ks);
	@Procedure
	void addbudget(double bon,double bud,double per);
}
