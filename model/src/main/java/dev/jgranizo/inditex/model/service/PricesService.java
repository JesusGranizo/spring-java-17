package dev.jgranizo.inditex.model.service;

import dev.jgranizo.inditex.model.entity.BrandEntity;
import dev.jgranizo.inditex.model.entity.PriceEntity;
import dev.jgranizo.inditex.model.entity.ProductEntity;

import java.util.Date;
import java.util.List;


public interface PricesService {
    void save(PriceEntity pricesEntity);

    List<PriceEntity> findAllByBrandIdAndProductIdAndDate(BrandEntity brandId, ProductEntity productId, Long date);
}
