package com.khodko.forestry.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "village")
public class Village implements BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="foo_sequence")
//    @SequenceGenerator(name="foo_sequence", sequenceName = "foo_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
