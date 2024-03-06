package com.example.jasperTest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@SpringBootApplication
public class JasperTestApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(JasperTestApplication.class, args);
		String filePath = "C:\\Users\\hands\\eclipse-workspace\\jasperTest\\src\\main\\resources\\templates\\graduate.jrxml";
		Map<String, Object> data = new HashMap<>();
		data.put("name", "hong gli dong");
		data.put("birth", "4202/06/03");
		data.put("date", "1000-01-01");
		data.put("id","020603-1234567");
		data.put("university", "you ni var city");
		JasperReport jrxmlFile = JasperCompileManager.compileReport(filePath);
		JasperPrint compiledFile = JasperFillManager.fillReport(jrxmlFile, data, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(compiledFile, "C:\\Users\\hands\\eclipse-workspace\\jasperTest\\src\\main\\resources\\static\\graduate.pdf");
	}

}
