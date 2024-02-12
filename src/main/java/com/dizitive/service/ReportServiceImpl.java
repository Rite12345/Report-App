package com.dizitive.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.dizitive.entity.CitizenPlan;
import com.dizitive.repository.CitizenPlanRepository;
import com.dizitive.request.SearchRequest;
import com.dizitive.util.EmailUtils;
import com.dizitive.util.ExcelGenerator;
import com.dizitive.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {
     
	@Autowired
	private CitizenPlanRepository repo; 
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public List<String> getPlanName() {
         List<String> planNames = repo.getPlanNames();
		return planNames ;
	}

	@Override
	public List<String> getPlanStatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity=new CitizenPlan();
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
			}
		
		
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
			}
		
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
			}
		
		if(null != request.getStartDate() && !"".equals(request.getStartDate()))
		{
			String startDate=request.getStartDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate=LocalDate.parse(startDate,formatter);
			entity.setPlanStartDate(localDate);
		}
		
		
		if(null != request.getEndDate() && !"".equals(request.getEndDate()))
		{
			String endDate=request.getEndDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate=LocalDate.parse(endDate,formatter);
			entity.setPlanEndDate(localDate);
		}
		
		
		
	return repo.findAll(Example.of(entity));
		
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		File f=new File("plans.xls");
		List<CitizenPlan> plans = repo.findAll();
		excelGenerator.generate(response, plans,f);
		String subject="Test mail subject";
		String body="<h1>Test mail body<h1>";
		String to="rk706473@gmail.com";
		
		
		
		emailUtils.sendEmail(subject, body, to,f); 
		f.delete();
		return true;
	}
    
	

	@Override
	public boolean exfortPdf(HttpServletResponse response) throws Exception {
		File f = new File("plans.pdf");
		List<CitizenPlan> plans = repo.findAll();
		pdfGenerator.generate(response, plans,f);
		String subject="Test mail subject";
		String body="<h1>Test mail body<h1>";
		String to="rk706473@gmail.com";
		
		
		
		emailUtils.sendEmail(subject, body, to,f); 
		f.delete();
		return true;
	}

}
