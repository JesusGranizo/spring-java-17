package dev.jgranizo.inditex.model.configuration;

import dev.jgranizo.inditex.model.entity.BrandEntity;
import dev.jgranizo.inditex.model.entity.PriceEntity;
import dev.jgranizo.inditex.model.entity.ProductEntity;
import dev.jgranizo.inditex.model.service.BrandsService;
import dev.jgranizo.inditex.model.service.PricesService;
import dev.jgranizo.inditex.model.service.ProductsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalField;

@Configuration
public class H2Configuration {

    private static final Logger log = LogManager.getLogger(H2Configuration.class);

    @Autowired
    private ProductsService productService;

    @Autowired
    private PricesService pricesService;

    @Autowired
    private BrandsService brandsService;

    @Bean
    public void createData() {

        // Brands //
        BrandEntity brandsEntity = new BrandEntity("Zara");

        this.brandsService.save(brandsEntity);

        // Products //
        ProductEntity productEntity = new ProductEntity(35455L, "Vestido Rojo", 38.95, "EUR");

        this.productService.save(productEntity);

        // Prices //
        PriceEntity priceEntity = new PriceEntity(
                brandsEntity,
                LocalDateTime.parse("2020-06-14T00:00:00.000").toInstant(ZoneOffset.UTC).toEpochMilli(),
                LocalDateTime.parse("2020-12-31T23:59:59").toInstant(ZoneOffset.UTC).toEpochMilli(),
                productEntity,
                0,
                35.50,
                "EUR"
        );
        PriceEntity priceEntity2 = new PriceEntity(
                brandsEntity,
                LocalDateTime.parse("2020-06-14T15:00:00").toInstant(ZoneOffset.UTC).toEpochMilli(),
                LocalDateTime.parse("2020-06-14T18:30:00").toInstant(ZoneOffset.UTC).toEpochMilli(),
                productEntity,
                1,
                25.45,
                "EUR"
        );
        PriceEntity priceEntity3 = new PriceEntity(
                brandsEntity,
                LocalDateTime.parse("2020-06-15T00:00:00").toInstant(ZoneOffset.UTC).toEpochMilli(),
                LocalDateTime.parse("2020-06-15T11:00:00").toInstant(ZoneOffset.UTC).toEpochMilli(),
                productEntity,
                1,
                30.50,
                "EUR"
        );
        PriceEntity priceEntity4 = new PriceEntity(
                brandsEntity,
                LocalDateTime.parse("2020-06-15T16:00:00").toInstant(ZoneOffset.UTC).toEpochMilli(),
                LocalDateTime.parse("2020-12-31T23:59:59").toInstant(ZoneOffset.UTC).toEpochMilli(),
                productEntity,
                1,
                38.95,
                "EUR"
        );

        this.pricesService.save(priceEntity);
        this.pricesService.save(priceEntity2);
        this.pricesService.save(priceEntity3);
        this.pricesService.save(priceEntity4);
    }
}
