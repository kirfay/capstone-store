package com.example.capstone.store.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@Entity

@ToString

@NoArgsConstructor

@AllArgsConstructor

@Table(name = "products")

public class Product {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")

    private Integer id;



    @Column(name = "name")

    private String name;



    @Column(name = "price")

    private Double price;


    @Column(name = "image_url")

    private String imageUrl;



    @Column(name = "description", columnDefinition = "TEXT")

    private String description;



}
