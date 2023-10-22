package dev.jgranizo.inditex.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BRANDS")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CREATION_DATE", nullable = false)
    private Long creationDate;

    @Column(name = "MODIFICATION_DATE", nullable = false)
    private Long modificationDate;

    public BrandEntity(String name) {
        this.name = name;
        this.creationDate = System.currentTimeMillis();
        this.modificationDate = System.currentTimeMillis();
    }

}
