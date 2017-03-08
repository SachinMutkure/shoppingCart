package com.sam.demo.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelBuilder extends AbstractExcelView{
	
	private static String reportName = null;

    CellStyle headerStyle;

    CellStyle cellStyle;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		reportName = (String) model.get("excelReportName");
		HSSFSheet sheet = workbook.createSheet("downloadedSheet");
		sheet.setDefaultColumnWidth(20);
		setStyle(workbook);
		
		List<?> list_objects = (List<Object>) model.get("excelModel");
        
		if (list_objects != null && list_objects.size() > 0) {        	
            Object obj = (Object) list_objects.get(0);           
            if (obj instanceof HashMap) {
                fillExcelSheetMap(sheet, reportName, (List<HashMap>) list_objects);
            } else {
                fillExcelSheet(sheet, reportName, (List<Object>) list_objects);
            }
        }		
	}
		
	@Autowired(required = false)
    private void fillExcelSheetMap(HSSFSheet sheet, String reportName, List<HashMap> list) {
        HSSFRow header = sheet.createRow(0);
        int cellNumber = 0;
        boolean createHeader = true;
        int rowIdx = 1;

        for (HashMap<String, String> cur_map : list) {

            try {
                
                if (createHeader) {
                    for (String key : cur_map.keySet()) {
                        // System.out.println(cur_field.getName() +" "+ cur_field.getType());
                        header.createCell(cellNumber).setCellValue(key + "");
                        header.getCell(cellNumber).setCellStyle(headerStyle);
                        cellNumber++;
                    }
                    createHeader = false;
                }
                
                HSSFRow cur_row = sheet.createRow(rowIdx);
                cellNumber = 0;
                for (String key : cur_map.keySet()) {
                    cur_row.createCell(cellNumber)
                        .setCellValue(cur_map.get(key) != null ? String.valueOf(cur_map.get(key)) : "" + "");
                    cellNumber++;
                }
                rowIdx++;
                
            } catch (Exception e) {
                // System.out.println(e);
                e.printStackTrace();
            }
        }
    }

    @Autowired(required = false)
    private void fillExcelSheet(HSSFSheet sheet, String reportName, List<?> list) {
        HSSFRow header = sheet.createRow(0);
        int cellNumber = 0;
        boolean createHeader = true;
        int rowIdx = 1;
        
        for (Object objlist : list) {
        	
            try {
                Class<?> theClass = objlist.getClass();
                Field[] fields = theClass.getDeclaredFields();
                
                if (createHeader) {
                    for (Field cur_field : fields) {
                        // System.out.println(cur_field.getName() +" "+ cur_field.getType());                  	 
                    	                    	
                    	MyCustomAnnotation annos = cur_field.getAnnotation(MyCustomAnnotation.class);                    	
                    	System.out.println("Current Field Annotation : "+annos.name());
                    	header.createCell(cellNumber).setCellValue(annos.name());
                        //header.createCell(cellNumber).setCellValue(cur_field.getName());
                        header.getCell(cellNumber).setCellStyle(headerStyle);
                        cellNumber++;
                    }
                    createHeader = false;
                }
                
                HSSFRow cur_row = sheet.createRow(rowIdx);
                cellNumber = 0;
                
                for (Field cur_field : fields) {
                	
                    String cur_property = cur_field.getName();
                    String gettterName = null;

                    if (cur_field.getType() == boolean.class) {
                        gettterName = "is" + cur_property.substring(0, 1).toUpperCase() + cur_property.substring(1);
                    } else {
                        gettterName = "get" + cur_property.substring(0, 1).toUpperCase() + cur_property.substring(1);
                    }

                    Method m = theClass.getMethod(gettterName);
                    Object value = (Object) m.invoke(objlist);
                    if (value != null) {
                        if (cur_field.getType() == Date.class) {
                            DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
                            // System.out.println(df.format(value));
                            cur_row.createCell(cellNumber).setCellValue(df.format(value) + "");
                        } else {
                            // System.out.println(value);
                            cur_row.createCell(cellNumber).setCellValue(value + "");
                        }
                    }
                    cellNumber++;
                }
                rowIdx++;
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }
	
    /** Set Excel sheet header style with it's 
     * text style and text color of header.  
     * @param workbook
     */
	private void setStyle(HSSFWorkbook workbook) {
	    headerStyle = workbook.createCellStyle();
	    HSSFFont font = workbook.createFont();
	    
	    font.setFontName("Arial");
	    headerStyle.setFillForegroundColor(HSSFColor.CORNFLOWER_BLUE.index);
	    headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    
	    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setColor(HSSFColor.GREY_80_PERCENT.index);
	    headerStyle.setFont(font);
	    
	    cellStyle = workbook.createCellStyle();
	    HSSFFont fonts = workbook.createFont();
	    fonts.setFontName("Arial");
	    fonts.setColor(HSSFColor.GREY_40_PERCENT.index);
	    cellStyle.setFont(fonts);
    }
}
