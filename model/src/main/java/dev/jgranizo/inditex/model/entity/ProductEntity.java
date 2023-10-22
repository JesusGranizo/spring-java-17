package dev.jgranizo.inditex.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DEFAULT_PRICE", nullable = false)
    private Double defaultPrice;

    @Column(name = "DEFAULT_CURR", nullable = false)
    private String defaultCurr;

    @Column(name = "CREATION_DATE", nullable = false)
    private Long creationDate;

    @Column(name = "MODIFICATION_DATE", nullable = false)
    private Long modificationDate;

    public ProductEntity(Long id, String name, Double defaultPrice, String defaultCurr) {
        this.id = id;
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.defaultCurr = defaultCurr;
        this.creationDate = System.currentTimeMillis();
        this.modificationDate = System.currentTimeMillis();
    }
}
