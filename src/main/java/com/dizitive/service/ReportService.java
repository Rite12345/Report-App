package com.dizitive.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dizitive.entity.CitizenPlan;
import com.dizitive.request.SearchRequest;

public interface ReportService {
	
	public List<String> getPlanName();
	public List<String> getPlanStatus();
	
    public List<CitizenPlan> search(SearchRequest request);

    public boolean exportExcel(HttpServletResponse response) throws Exception;
    public boolean exfortPdf(HttpServletResponse response) throws Exception;
    
}
