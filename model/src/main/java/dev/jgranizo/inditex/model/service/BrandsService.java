package dev.jgranizo.inditex.model.service;

import dev.jgranizo.inditex.model.entity.BrandEntity;


public interface BrandsService {
    void save(BrandEntity brandsEntity);

    BrandEntity findById(Long brandId);
}
