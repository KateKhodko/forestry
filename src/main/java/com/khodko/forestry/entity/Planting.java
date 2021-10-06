package com.khodko.forestry.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planting")
public class Planting implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ToString.Exclude
    @OneToMany(mappedBy = "planting", cascade = CascadeType.ALL)
    private Set<Tree> tree;
}
