package dev.jgranizo.inditex.model.service.impl;

import dev.jgranizo.inditex.model.entity.ProductEntity;
import dev.jgranizo.inditex.model.repository.ProductsRepository;
import dev.jgranizo.inditex.model.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public void save(ProductEntity productEntity) {
        this.productsRepository.save(productEntity);
    }

    @Override
    public ProductEntity findById(Long productId) {
        return this.productsRepository.findById(productId).orElse(null);
    }
}
