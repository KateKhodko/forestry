package com.khodko.forestry.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "forestry")
@Data
public class Forestry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private Village village;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forester_id")
    private Forester forester;

    @OneToMany(mappedBy = "forestry", cascade = CascadeType.ALL)
    private Set<Planting> plantings = new HashSet<>();
}
