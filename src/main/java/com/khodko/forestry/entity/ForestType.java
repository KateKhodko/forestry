package com.khodko.forestry.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "forest_type")
public class ForestType implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;


    @OneToMany(mappedBy = "forestType", cascade = CascadeType.ALL)
    private Set<TreeKind> treeKindSet;

}

