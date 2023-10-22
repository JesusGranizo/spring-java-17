package dev.jgranizo.inditex.model.service;

import dev.jgranizo.inditex.model.entity.ProductEntity;


public interface ProductsService {
    void save(ProductEntity productEntity);

    ProductEntity findById(Long productId);
}
