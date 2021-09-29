package com.khodko.forestry.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "forester")
@Data
public class Forester extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

}
