package com.aplikasi.chapter7.binarfud.repository;
import com.aplikasi.chapter7.binarfud.entity.Customer;
import com.aplikasi.chapter7.binarfud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> , JpaSpecificationExecutor<Order> {
    Optional<Order> findByCustomerId(Customer customer);
    //
}
