package dev.jgranizo.inditex.model.service.impl;

import dev.jgranizo.inditex.model.entity.BrandEntity;
import dev.jgranizo.inditex.model.entity.PriceEntity;
import dev.jgranizo.inditex.model.entity.ProductEntity;
import dev.jgranizo.inditex.model.repository.PricesRepository;
import dev.jgranizo.inditex.model.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public void save(PriceEntity pricesEntity) {
        this.pricesRepository.save(pricesEntity);
    }

    public List<PriceEntity> findAllByBrandIdAndProductIdAndDate(BrandEntity brandId, ProductEntity productId, Long date) {
        return this.pricesRepository.findAllPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, date, date);
    }
}
