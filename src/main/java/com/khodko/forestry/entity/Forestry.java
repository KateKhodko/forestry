package com.khodko.forestry.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "forestry")
public class Forestry implements BaseEntity {

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

//    @ToString.Exclude
    @OneToMany(mappedBy = "forestry", cascade = CascadeType.ALL)
    private Set<Planting> plantings;
}

