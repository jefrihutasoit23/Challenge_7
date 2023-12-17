package com.aplikasi.chapter7.binarfud.service.impl;

import com.aplikasi.chapter7.binarfud.entity.Merchant;
import com.aplikasi.chapter7.binarfud.service.MerchantService;
import com.aplikasi.chapter7.binarfud.repository.MerchantRepository;
import com.aplikasi.chapter7.binarfud.utils.Config;
import com.aplikasi.chapter7.binarfud.utils.TemplateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private TemplateResponse response;

    @Override
    public Map addMerchant(Merchant merchant) {
        try {
            log.info("add Merchant");
            return response.sukses(merchantRepository.save(merchant));
        }catch (Exception e){
            log.error("add Merchant error: "+e.getMessage());
            return response.Error("add Merchant ="+e.getMessage());
        }
    }

    @Override
    public Map updateMerchantStatus(Merchant merchant) {
        try {
            log.info("Update merchant Status");
            if (merchant.getId() == null) {
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Merchant> chekDataDBMerchant = merchantRepository.findById(merchant.getId());
            if (chekDataDBMerchant.isEmpty()) {
                return response.Error(Config.MERCHANT_NOT_FOUND);
            }
            chekDataDBMerchant.get().setOpen(merchant.getOpen());
            chekDataDBMerchant.get().setUpdated_date(new Date());

            return response.sukses(merchantRepository.save(chekDataDBMerchant.get()));
        }catch (Exception e){
            log.error("Update merchant Status error: "+e.getMessage());
            return response.Error("Update merchant Status="+e.getMessage());
        }
    }

    @Override
    public Map update(Merchant merchant) {
        try {
            log.info("Update merchant");
            if (merchant.getId() == null) {
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Merchant> chekDataDBMerchant = merchantRepository.findById(merchant.getId());
            if (chekDataDBMerchant.isEmpty()) {
                return response.Error(Config.MERCHANT_NOT_FOUND);
            }

            chekDataDBMerchant.get().setMerchant_name(merchant.getMerchant_name());
            chekDataDBMerchant.get().setMerchant_location(merchant.getMerchant_location());
            chekDataDBMerchant.get().setOpen(merchant.getOpen());
            chekDataDBMerchant.get().setUpdated_date(new Date());

            return response.sukses(merchantRepository.save(chekDataDBMerchant.get()));
        }catch (Exception e){
            log.error("Update merchant error: "+e.getMessage());
            return response.Error("Update merchant ="+e.getMessage());
        }
    }

    @Override
    public Map delete(Merchant merchant) {
        try {
            log.info("Delete merchant");
            if (merchant.getId() == null) {
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Merchant> chekDataDBMerchant = merchantRepository.findById(merchant.getId());
            if (chekDataDBMerchant.isEmpty()) {
                return response.Error(Config.MERCHANT_NOT_FOUND);
            }

            chekDataDBMerchant.get().setDeleted_date(new Date());
            merchantRepository.save(chekDataDBMerchant.get());
            return response.sukses(Config.SUCCESS);
        }catch (Exception e){
            log.error("Delete merchant error: "+e.getMessage());
            return response.Error("Delete merchant ="+e.getMessage());
        }
    }

    @Override
    public Map getByID(Long merchant) {
        Optional<Merchant> getBaseOptional = merchantRepository.findById(merchant);
        if(getBaseOptional.isEmpty()){
            return response.notFound(getBaseOptional);
        }
        return response.templateSukses(getBaseOptional);
    }

    @Override
    public List<Merchant> getOpenMerchants() {
        return merchantRepository.findByOpenIsTrue();
    }
}
