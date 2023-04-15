package com.grupolainmaculada.cloud.inventoryservice.demo;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductId;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("testdata")
public class ProductDataLoader {

    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadProductTestData() {
        var id1 = ProductId.of("002", "001", "001", "30028600");
        var id2 = ProductId.of("002", "001", "001", "30026377");
        var p1 = Product.of(id1, "AVENA GRANO DE ORO KIWICH 170G", 1,
                new BigDecimal("1.50"), new BigDecimal("1.1530"));
        var p2 = Product.of(id2, "AVENA GRANO DE ORO MACA 170G", 1,
                new BigDecimal("1.80"), new BigDecimal("1.3419"));
        productRepository.save(p1);
        productRepository.save(p2);
    }


}
