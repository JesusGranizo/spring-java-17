package dev.jgranizo.inditex.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID")
    private BrandEntity brandId;

    @Column(name = "START_DATE", nullable = false)
    private Long startDate;

    @Column(name = "END_DATE", nullable = false)
    private Long endDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_ID", unique = true, nullable = false)
    private Long priceId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private ProductEntity productId;

    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "ISO", nullable = false)
    private String curr;

    @Column(name = "CREATION_DATE", nullable = false)
    private Long creationDate;

    @Column(name = "MODIFICATION_DATE", nullable = false)
    private Long modificationDate;

    public PriceEntity(BrandEntity brandId, Long startDate, Long endDate, ProductEntity productId, Integer priority, Double price, String curr) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
        this.creationDate = System.currentTimeMillis();
        this.modificationDate = System.currentTimeMillis();
    }
}
