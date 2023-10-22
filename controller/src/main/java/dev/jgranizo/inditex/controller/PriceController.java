package dev.jgranizo.inditex.controller;

import dev.jgranizo.inditex.controller.error.ErrorType;
import dev.jgranizo.inditex.definition.api.PriceApi;
import dev.jgranizo.inditex.definition.model.ErrorDefinition;
import dev.jgranizo.inditex.definition.model.PriceRequest;
import dev.jgranizo.inditex.definition.model.PriceResponse;
import dev.jgranizo.inditex.model.entity.BrandEntity;
import dev.jgranizo.inditex.model.entity.PriceEntity;
import dev.jgranizo.inditex.model.entity.ProductEntity;
import dev.jgranizo.inditex.model.service.BrandsService;
import dev.jgranizo.inditex.model.service.PricesService;
import dev.jgranizo.inditex.model.service.ProductsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class PriceController implements PriceApi {

    private static final Logger log = LogManager.getLogger(PriceController.class);

    @Autowired
    private PricesService pricesService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private BrandsService brandsService;

    @Override
    public ResponseEntity<PriceResponse> getPrice(PriceRequest priceRequest) {

        log.info("Searching price for brandId {}, productId {} and date {}", priceRequest.getBrandId(), priceRequest.getProductId(), priceRequest.getDate());
        ResponseEntity responseEntity = null;

        if (priceRequest.getBrandId() == null || priceRequest.getProductId() == null || priceRequest.getDate() == null) {
            log.debug("Invalid parameters, brandId, productId and date are required");
            ErrorDefinition error = new ErrorDefinition();
            error.setCode(ErrorType.INVALID_PARAMETERS.getCode());
            error.setMessage("Invalid parameters, brandId, productId and date are required");
            responseEntity = new ResponseEntity<>(error, ErrorType.INVALID_PARAMETERS.getHttpStatus());
            return responseEntity;
        }

        BrandEntity brandEntity = this.brandsService.findById(Long.valueOf(priceRequest.getBrandId()));

        if (brandEntity == null) {
            log.debug("Brand with id {} not found", priceRequest.getBrandId());
            ErrorDefinition error = new ErrorDefinition();
            error.setCode(ErrorType.BRAND_NOT_FOUND.getCode());
            error.setMessage("Brand not found");
            responseEntity = new ResponseEntity<>(error, ErrorType.BRAND_NOT_FOUND.getHttpStatus());
            return responseEntity;
        }

        ProductEntity productEntity = this.productsService.findById(Long.valueOf(priceRequest.getProductId()));
        if (productEntity == null) {
            log.debug("Product with id {} not found", priceRequest.getProductId());
            ErrorDefinition error = new ErrorDefinition();
            error.setCode(ErrorType.PRODUCT_NOT_FOUND.getCode());
            error.setMessage("Product not found");
            responseEntity = new ResponseEntity<>(error, ErrorType.PRODUCT_NOT_FOUND.getHttpStatus());
            return responseEntity;
        }

        List<PriceEntity> priceEntities = this.pricesService.findAllByBrandIdAndProductIdAndDate(brandEntity, productEntity, priceRequest.getDate().toInstant().toEpochMilli());
        if (priceEntities == null || priceEntities.isEmpty()) {
            log.debug("Price not found, searching for default price for product with id {}", priceRequest.getProductId());
            PriceResponse priceResponse = new PriceResponse(
                    brandEntity.getId().intValue(),
                    productEntity.getId().intValue(),
                    productEntity.getDefaultPrice(),
                    productEntity.getDefaultCurr()
            );
            return ResponseEntity.ok(priceResponse);
        }

        PriceResponse priceResponse = new PriceResponse(
                priceEntities.get(0).getBrandId().getId().intValue(),
                priceEntities.get(0).getProductId().getId().intValue(),
                priceEntities.get(0).getPrice(),
                priceEntities.get(0).getCurr()
        );
        priceResponse.setPriceId(priceEntities.get(0).getPriceId().intValue());
        priceResponse.setStartDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.ofInstant(Instant.ofEpochMilli(priceEntities.get(0).getStartDate()), ZoneOffset.UTC)));
        priceResponse.setEndDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.ofInstant(Instant.ofEpochMilli(priceEntities.get(0).getEndDate()), ZoneOffset.UTC)));
        return ResponseEntity.ok(priceResponse);
    }
}
