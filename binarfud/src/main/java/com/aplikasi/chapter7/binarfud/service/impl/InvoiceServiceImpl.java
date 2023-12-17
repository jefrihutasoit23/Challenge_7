package com.aplikasi.chapter7.binarfud.service.impl;

import com.aplikasi.chapter7.binarfud.entity.Customer;
import com.aplikasi.chapter7.binarfud.entity.Merchant;
import com.aplikasi.chapter7.binarfud.repository.MerchantRepository;
import com.aplikasi.chapter7.binarfud.repository.CustomerRepository;
import com.aplikasi.chapter7.binarfud.service.InvoiceService;
import com.aplikasi.chapter7.binarfud.utils.Config;
import com.aplikasi.chapter7.binarfud.utils.TemplateResponse;
import com.aplikasi.chapter7.binarfud.utils.jasper.ReportService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private TemplateResponse response;

    @Autowired
    private ReportService1 reportService;
    @Override
    public Map generateInvoice(Customer customer) {
        try {
            log.info("generate invoice");
            if (customer.getId() == null) {
                return response.Error(Config.ID_REQUIRED);
            }
            if (customer.getNama() == null) {
                return response.Error(Config.USERNAME_REQUIRED);
            }
            Optional<Customer> chekDataDBUser = customerRepository.findById(customer.getId());
            if (chekDataDBUser.isEmpty()) {
                return response.Error(Config.USER_NOT_FOUND);
            }
            Long id = customer.getId();

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("IdUser", id);
            String pathUrl = ".\\src\\main\\resources\\User2.jrxml";
            String fileName = "invoice pembelian "+ customer.getNama();
            return response.sukses(reportService.generate_pdf(parameters,pathUrl,fileName));
        } catch (Exception e) {
            log.error("generate invoice: " + e.getMessage());
            return response.Error("generate invoice =" + e.getMessage());
        }
    }
    @Override
    public Map generateReport(Merchant merchant) {
        try {
            log.info("generate Report");
            if (merchant.getId() == null) {
                return response.Error(Config.ID_REQUIRED);
            }
            if (merchant.getMerchant_name() == null) {
                return response.Error(Config.MERCHANT_NAME_REQUIRED);
            }
            Optional<Merchant> chekDataDBMerchant = merchantRepository.findById(merchant.getId());
            if (chekDataDBMerchant.isEmpty()) {
                return response.Error(Config.MERCHANT_NOT_FOUND);
            }
            Long id = merchant.getId();

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("IdMerchant", id);
            String pathUrl = ".\\src\\main\\resources\\Merchant.jrxml";
            String fileName = "Reporting Merchant "+merchant.getMerchant_name();
            return response.sukses(reportService.generate_pdf(parameters,pathUrl,fileName));
        } catch (Exception e) {
            log.error("generate Report: " + e.getMessage());
            return response.Error("generate Report =" + e.getMessage());
        }
    }
}
