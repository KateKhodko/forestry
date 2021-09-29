package com.khodko.forestry.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tree")
@Data
public class Tree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @ManyToOne
    @JoinColumn(name = "planting_id")
    private Planting planting;
}
