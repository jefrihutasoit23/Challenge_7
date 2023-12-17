package com.aplikasi.chapter7.binarfud.service;

import com.aplikasi.chapter7.binarfud.entity.Customer;
import com.aplikasi.chapter7.binarfud.entity.Merchant;

import java.util.Map;

public interface InvoiceService {
    Map generateInvoice(Customer customer);
    Map generateReport(Merchant merchant);
}
