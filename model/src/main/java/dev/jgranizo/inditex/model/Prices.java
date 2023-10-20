package dev.jgranizo.inditex.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRICES")
public class Prices {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID")
    private Brands brandId;

    @Getter
    @Setter
    @Column(name = "START_DATE", nullable = false)
    private Long startDate;

    @Getter
    @Setter
    @Column(name = "END_DATE", nullable = false)
    private Long endDate;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_LIST", unique = true, nullable = false)
    private Long priceList;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product productId;

    @Getter
    @Setter
    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @Getter
    @Setter
    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Getter
    @Setter
    @Column(name = "ISO", nullable = false)
    private String curr;

    @Getter
    @Setter
    @Column(name = "CREATION_DATE", nullable = false)
    private Long creationDate;

    @Getter
    @Setter
    @Column(name = "MODIFICATION_DATE", nullable = false)
    private Long modificationDate;
}
