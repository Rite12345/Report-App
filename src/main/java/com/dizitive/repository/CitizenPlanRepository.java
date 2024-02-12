 package com.dizitive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dizitive.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan,Integer> {
	//sql custom Query
//@Query(value="select distinct(plan_name) from jrtp.citizen_plan_info",nativeQuery=true)
//	public List<String> getPlanNames();
//	
//@Query(value="select  distinct(plan_status) from jrtp.citizen_plans_info",nativeQuery=true)
//public List<String> getPlanStatus();

  //HQL custom Query
@Query("select distinct(planName) from CitizenPlan")
List<String> getPlanNames();

@Query("select distinct(planStatus) from CitizenPlan")
List<String> getPlanStatus();
}
