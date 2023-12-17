package com.aplikasi.chapter7.binarfud.utils.jasper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Main {
    @Autowired
    public  ReportService1 reportService1;

    @Test
    public  void testPembelianUser() throws SQLException {
        Map<String, Object> parameters33 = new HashMap<>();
        parameters33.put("IdUser", 1L);
        String pathUrl = ".\\src\\main\\resources\\User2.jrxml";
        String fileName = "invoice pembelian";
        reportService1.generate_pdf(parameters33,pathUrl,fileName);
        reportService1.generateHtml(parameters33,pathUrl,fileName);
        reportService1.generate_excel(parameters33,pathUrl,fileName);
        reportService1.generateCSV(parameters33,pathUrl,fileName);
        reportService1.generateDocx(parameters33,pathUrl,fileName);
    }
    @Test
    public  void testReportingMerchant() throws SQLException {
        Map<String, Object> parameters33 = new HashMap<>();
        parameters33.put("IdMerchant", 4L);
        String pathUrl = ".\\src\\main\\resources\\Merchant.jrxml";
        String fileName = "Reporting Merchant saya";
        reportService1.generate_pdf(parameters33,pathUrl,fileName);
        reportService1.generateHtml(parameters33,pathUrl,fileName);
        reportService1.generate_excel(parameters33,pathUrl,fileName);
        reportService1.generateCSV(parameters33,pathUrl,fileName);
        reportService1.generateDocx(parameters33,pathUrl,fileName);
    }
}

