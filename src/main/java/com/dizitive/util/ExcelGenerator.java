package com.dizitive.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.dizitive.entity.CitizenPlan;

@Component
public class ExcelGenerator {
	
	//private CitizenPlanRepository repo;
	
	public void generate(HttpServletResponse response,List<CitizenPlan> records,File file) throws Exception{
		//Workbook workbook=new HSSFWorkbook();
				Workbook workbook=new HSSFWorkbook();
				Sheet sheet = workbook.createSheet("plans-data");
				Row headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("Id");
				headerRow.createCell(1).setCellValue("Citizen Name");
				headerRow.createCell(2).setCellValue("Plan Name");
				headerRow.createCell(3).setCellValue("Plan Status");
			
				headerRow.createCell(4).setCellValue("Plan Start Date");
				headerRow.createCell(5).setCellValue("Plane End Date");
				headerRow.createCell(6).setCellValue("Benifit Amt");
				
				//List<CitizenPlan> records = repo.findAll();
		      int dataRowIndex=1;
				for(CitizenPlan plan: records)
				{
					Row dataRow = sheet.createRow(dataRowIndex);
					dataRow.createCell(0).setCellValue(plan.getCitizenId());
					dataRow.createCell(1).setCellValue(plan.getCitizenName());
					dataRow.createCell(2).setCellValue(plan.getPlanName());
					dataRow.createCell(3).setCellValue(plan.getPlanStatus());
					if(null !=plan.getPlanStartDate())
					{
					dataRow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
					}else {
						dataRow.createCell(4).setCellValue("N/A");
					}
					if(null !=plan.getPlanEndDate())
					{
					dataRow.createCell(5).setCellValue(plan.getPlanEndDate()+"");
					}else {
						dataRow.createCell(5).setCellValue("N/A");

					}
					if(null !=plan.getBenefitAmt())
					{
					dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
					}else {
						dataRow.createCell(6).setCellValue("N/A");

					}
					
					dataRowIndex++;
				}
				
				//FileOutputStream fos=new FileOutputStream(new File("plans.xls"));
				 //workbook.write(fos);
				//workbook.close();
				
				FileOutputStream fos= new FileOutputStream(file);
				workbook.write(fos);
				fos.close();
				
				ServletOutputStream outputStream = response.getOutputStream();
				workbook.write(outputStream);
				workbook.close();
				
	}

}
