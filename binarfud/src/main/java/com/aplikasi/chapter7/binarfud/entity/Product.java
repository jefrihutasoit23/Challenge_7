package com.aplikasi.chapter7.binarfud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@Where(clause = "deleted_date is null")
public class Product extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant; // Hubungan dengan entitas Merchant

}

