package com.aplikasi.chapter7.binarfud.repository;
import com.aplikasi.chapter7.binarfud.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> , JpaSpecificationExecutor<OrderDetail> {
    //
}
