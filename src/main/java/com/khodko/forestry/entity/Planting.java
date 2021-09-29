package com.khodko.forestry.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "planting")
@Data
public class Planting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "square", nullable = false)
    private int square;

    @ManyToOne
    @JoinColumn(name = "forestry_id")
    private Forestry forestry;

    @ManyToOne
    @JoinColumn(name = "tree_kind_id")
    private TreeKind treeKind;

    @OneToMany(mappedBy = "planting", cascade = CascadeType.ALL)
    private Set<Tree> tree;
}
