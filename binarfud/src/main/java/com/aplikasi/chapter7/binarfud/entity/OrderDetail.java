package com.aplikasi.chapter7.binarfud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "total_price")
    private Long total_price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order; // Hubungan dengan entitas Order

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // Hubungan dengan entitas Product
}

