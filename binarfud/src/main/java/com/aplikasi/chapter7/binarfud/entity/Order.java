package com.aplikasi.chapter7.binarfud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_time")
    private Date order_time;

    @Column(name = "destination_address")
    private String destination_address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; // Hubungan dengan entitas User

    @Column(name = "completed")
    private Boolean completed;
}
