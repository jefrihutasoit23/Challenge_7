package com.aplikasi.chapter7.binarfud.service;

import com.aplikasi.chapter7.binarfud.entity.OrderDetail;

import java.util.Map;

public interface OrderDetailService {
    Map addOrderDetail(OrderDetail orderDetail);
    Map updateOrderDetail(OrderDetail orderDetail);
    Map deleteOrderDetail(OrderDetail orderDetail);
    Map getByID(Long orderDetail);
}
