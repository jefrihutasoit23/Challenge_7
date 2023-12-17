package com.aplikasi.chapter7.binarfud.service.impl;

import com.aplikasi.chapter7.binarfud.service.OrderDetailService;
import com.aplikasi.chapter7.binarfud.entity.OrderDetail;
import com.aplikasi.chapter7.binarfud.repository.OrderDetailRepository;
import com.aplikasi.chapter7.binarfud.utils.Config;
import com.aplikasi.chapter7.binarfud.utils.TemplateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private TemplateResponse response;

    @Override
    public Map addOrderDetail(OrderDetail orderDetail) {
        try {
            log.info("add Order Detail");
            return response.sukses(orderDetailRepository.save(orderDetail));
        }catch (Exception e){
            log.error("add order Detail error: "+e.getMessage());
            return response.Error("add order Detail ="+e.getMessage());
        }
    }

    @Override
    public Map updateOrderDetail(OrderDetail orderDetail) {
        try {
            log.info("Update order Detail");
            if (orderDetail.getId() == null) {
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<OrderDetail> chekDataDBorderDetail = orderDetailRepository.findById(orderDetail.getId());
            if (chekDataDBorderDetail.isEmpty()) {
                return response.Error(Config.ORDER_DETAIL_NOT_FOUND);
            }

            chekDataDBorderDetail.get().setQuantity(orderDetail.getQuantity());
            chekDataDBorderDetail.get().setTotal_price(orderDetail.getTotal_price());
            chekDataDBorderDetail.get().setOrder(orderDetail.getOrder());
            chekDataDBorderDetail.get().setProduct(orderDetail.getProduct());
            chekDataDBorderDetail.get().setUpdated_date(new Date());

            return response.sukses(orderDetailRepository.save(chekDataDBorderDetail.get()));
        }catch (Exception e){
            log.error("Update order Detail error: "+e.getMessage());
            return response.Error("Update order Detail ="+e.getMessage());
        }
    }
    @Override
    public Map deleteOrderDetail(OrderDetail orderDetail) {
        try {
            log.info("delete order Detail");
            if (orderDetail.getId() == null) {
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<OrderDetail> chekDataDBorderDetail = orderDetailRepository.findById(orderDetail.getId());
            if (chekDataDBorderDetail.isEmpty()) {
                return response.Error(Config.ORDER_DETAIL_NOT_FOUND);
            }
            chekDataDBorderDetail.get().setDeleted_date(new Date());
            orderDetailRepository.save(chekDataDBorderDetail.get());
            return response.sukses(Config.SUCCESS);
        }catch (Exception e){
            log.error("delete order Detail error: "+e.getMessage());
            return response.Error("delete order Detail ="+e.getMessage());
        }
    }
    @Override
    public Map getByID(Long orderDetail) {
        Optional<OrderDetail> getBaseOptional = orderDetailRepository.findById(orderDetail);
        if(getBaseOptional.isEmpty()){
            return response.notFound(getBaseOptional);
        }
        return response.templateSukses(getBaseOptional);
    }
}
