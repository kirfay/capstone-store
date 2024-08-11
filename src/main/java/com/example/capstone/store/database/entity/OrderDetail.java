package com.example.capstone.store.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@Entity

@ToString

@NoArgsConstructor

@AllArgsConstructor

@Table(name = "order_details")

public class OrderDetail {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")

    private Integer id;


    @Column(name = "order_id")

    private Integer orderId;


    @Column(name = "product_id")
    private Integer productId;


    @Column(name = "quantity")

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
}
