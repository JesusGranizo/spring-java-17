package dev.jgranizo.inditex.model.service.impl;

import dev.jgranizo.inditex.model.entity.BrandEntity;
import dev.jgranizo.inditex.model.repository.BrandRepository;
import dev.jgranizo.inditex.model.service.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandsServiceImpl implements BrandsService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void save(BrandEntity brandsEntity) {
        this.brandRepository.save(brandsEntity);
    }

    @Override
    public BrandEntity findById(Long brandId) {
        return this.brandRepository.findById(brandId).orElse(null);
    }
}
