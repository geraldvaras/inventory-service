package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@ActiveProfiles("integration")
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findProductByIdWheExisting() {
        var id = ProductId.of("002", "001", "001","30090780");
        var product = Product.of(id, "JAMON SERRANO TERRAZA D/LOM100", 1,
                new BigDecimal("15.00"), new BigDecimal("11.9003"));
        productRepository.save(product);
        Optional<Product> actualProduct = productRepository.findById(id);

        assertThat(actualProduct).isPresent();
        assertThat(actualProduct.get().getId().getCode()).isEqualTo(id.getCode());

    }
}
