package com.aplikasi.chapter7.binarfud.service;

import com.aplikasi.chapter7.binarfud.entity.Merchant;

import java.util.List;
import java.util.Map;

public interface MerchantService {
    Map addMerchant(Merchant merchant);
    Map updateMerchantStatus(Merchant merchant);
    Map update(Merchant merchant);
    Map delete(Merchant merchant);
    Map getByID(Long merchant);
    List<Merchant> getOpenMerchants();
}
