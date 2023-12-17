package com.aplikasi.chapter7.binarfud.service.impl;

import com.aplikasi.chapter7.binarfud.entity.Merchant;
import com.aplikasi.chapter7.binarfud.entity.Product;
import com.aplikasi.chapter7.binarfud.repository.MerchantRepository;
import com.aplikasi.chapter7.binarfud.repository.ProductRepository;
import com.aplikasi.chapter7.binarfud.service.ProductService;
import com.aplikasi.chapter7.binarfud.utils.Config;
import com.aplikasi.chapter7.binarfud.utils.TemplateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.time.LocalTime.now;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    public TemplateResponse response;
    @Override
    public Map addProduct(Product product) {
        try {
            log.info("add Product");
            if(product.getProduct_name().isEmpty()){
                return response.Error(Config.NAME_REQUIRED);
            }
            if(product.getMerchant() ==null && product.getMerchant().getId() == null){
                return response.Error(Config.MERCHANT_REQUIRED);
            }
            Optional<Merchant> chekDataDB = merchantRepository.findById(product.getMerchant().getId());
            if(chekDataDB.isEmpty()){
                return response.Error(Config.MERCHANT_NOT_FOUND);
            }
            product.setMerchant(chekDataDB.get());
            return response.sukses(productRepository.save(product));
        }catch (Exception e){
            log.error("add Product error: "+e.getMessage());
            return response.Error("add Product ="+e.getMessage());
        }
    }
    @Override
    public Map updateProduct(Product product) {
        try {
            log.info("Update Product");
            if(product.getId() == null ){
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Product> chekDataDBProduct = productRepository.findById(product.getId());
            if(chekDataDBProduct.isEmpty()){
                return response.Error(Config.PRODUCT_NOT_FOUND);
            }

            if(product.getMerchant() ==null && product.getMerchant().getId() == null){
                return response.Error(Config.MERCHANT_REQUIRED);
            }
            Optional<Merchant> chekDataDB = merchantRepository.findById(product.getMerchant().getId());
            if(chekDataDB.isEmpty()){
                return response.Error(Config.MERCHANT_NOT_FOUND);
            }

            chekDataDBProduct.get().setProduct_name(product.getProduct_name());
            chekDataDBProduct.get().setPrice(product.getPrice());
            chekDataDBProduct.get().setMerchant(chekDataDB.get());
            chekDataDBProduct.get().setUpdated_date(new Date());

            return response.sukses(productRepository.save(chekDataDBProduct.get()));
        }catch (Exception e){
            log.error("Update Product error: "+e.getMessage());
            return response.Error("Update Product ="+e.getMessage());
        }
    }
    @Override
    public Map deleteProduct(Product product) {
        try {
            log.info("Delete Product");
            if(product.getId() ==null ){
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Product> chekDataDBProduct = productRepository.findById(product.getId());
            if(chekDataDBProduct.isEmpty()){
                return response.Error(Config.PRODUCT_NOT_FOUND);
            }

            chekDataDBProduct.get().setDeleted_date(new Date());

            productRepository.save(chekDataDBProduct.get());
            return response.sukses(Config.SUCCESS);
        }catch (Exception e){
            log.error("Delete Product eror: "+e.getMessage());
            return response.Error("Delete Product ="+e.getMessage());
        }
    }
    @Override
    public Map getByID(Long product) {
        Optional<Product> getBaseOptional = productRepository.findById(product);
        if(getBaseOptional.isEmpty()){
            return response.notFound(getBaseOptional);
        }
        return response.templateSukses(getBaseOptional);
    }
    @Override
    public List<Product> getAvailableProducts() {
        return productRepository.findAll();
    }
}
