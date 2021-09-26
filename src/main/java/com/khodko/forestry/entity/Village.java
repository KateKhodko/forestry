package com.khodko.forestry.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "village")
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "villageName", nullable = false)
    private Long villageName;

    public Village() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Village village = (Village) o;
        return Objects.equals(id, village.id) && Objects.equals(villageName, village.villageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, villageName);
    }

    @Override
    public String toString() {
        return "Village{" +
                "id=" + id +
                ", villageName=" + villageName +
                '}';
    }
}
