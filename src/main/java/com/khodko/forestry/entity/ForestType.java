package com.khodko.forestry.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "forest_type")
@Data
public class ForestType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @OneToMany(mappedBy = "forestType", cascade = CascadeType.ALL)
    private Set<TreeKind> treeKindSet;

}

