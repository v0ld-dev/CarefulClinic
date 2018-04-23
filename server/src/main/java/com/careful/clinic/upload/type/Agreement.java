package com.careful.clinic.upload.type;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.careful.clinic.upload.interfase.IDataUploadType;

public class Agreement extends AbstractDataUploadType{
	
	public Agreement (){
	}
	
	public Agreement (OPCPackage pkg){
		super.set(pkg);
	}

	@Override
	IDataUploadType getInstansUploadData() {
		System.out.println("Отдаю инстанс "+this.getClass().getName());
		return this;
	}

	@Override
	public void checkOutStructure() {
		
		//if(sheet.getPhysicalNumberOfRows() > 50_000){ pkg.close(); throw new Exception("Превышено допустимое количество строк в загружаемом файле. Не более 50 000 строк");}
		
	}

	@Override
	public void checkOutTypizine() {
		System.out.println("Проверяю типизацию "+this.getClass().getName());
		
	}
	
	@Override
	public void checkSinchronizeData(List<String> listquery){
		String []mas = null;
		for(int i=0; i < listquery.size(); i++){
		mas =	listquery.get(i).split(",");
			
		}
		
	}

	@Override
	public List<String> constructQuery() throws  ParseException, IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(super.pkg);
		Sheet sheet =  workbook.getSheetAt(0);
		
		DataFormatter formatter = new DataFormatter();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat df3 = new SimpleDateFormat("dd.MM.yyyy");
		
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>(sheet.getPhysicalNumberOfRows());
		Row row = sheet.getRow(0);
		
		String cell_SMO = String.valueOf(sheet.getRow(2).getCell(1).getNumericCellValue());
		
		for(int j=4; j< sheet.getPhysicalNumberOfRows(); j++){
			row = sheet.getRow(j);
			// первовым идем ид. Его не вставляю.
			sb.append("insert into pm_assent p values('',");
			
			for(int i=0; i<row.getLastCellNum() && i < 6; i++){
				sb.append("'");	
				if(i == 3 || i == 4){
					try{
						sb.append(df2.format(df.parse(row.getCell(i).toString())));
					}catch ( java.text.ParseException e) {
						sb.append(df2.format(df3.parse(row.getCell(i).toString())));
					}
				}else{
					sb.append(formatter.formatCellValue(row.getCell(i)).toUpperCase());
				}
				sb.append("'");
				sb.append(",");
				if(i == 4) sb.append(" '', ");
			}
			sb.append("");
			sb.append(" '',"+cell_SMO+" ,sysdate)");
			
			list.add(sb.toString());
			sb.delete(0, sb.length());
		}
		
		super.pkg.close();
		
		
		return list;
	}

	@Override
	public void checkSinchronizeData() {
		// TODO Auto-generated method stub
		
	}


}
