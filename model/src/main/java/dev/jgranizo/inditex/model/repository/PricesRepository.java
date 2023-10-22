package dev.jgranizo.inditex.model.repository;

import dev.jgranizo.inditex.model.entity.BrandEntity;
import dev.jgranizo.inditex.model.entity.PriceEntity;
import dev.jgranizo.inditex.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long> {

    public List<PriceEntity> findAllPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(BrandEntity brandId, ProductEntity productId, Long date, Long date2);

}
