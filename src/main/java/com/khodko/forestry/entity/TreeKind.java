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
@Table(name = "tree_kind")
public class TreeKind implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "treeKind", cascade = CascadeType.ALL)
    private Set<Planting> plantings;

    @ManyToOne
    @JoinColumn(name = "forest_type_id")
    private ForestType forestType;

}
