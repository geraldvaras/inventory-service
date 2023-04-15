package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import com.grupolainmaculada.cloud.inventoryservice.config.DataConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
public class ProductRepositoryJpaTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findProductByIdWhenExisting() {
        var id = ProductId.of("002", "001", "001", "30028600");
        var product = Product.of(id, "AVENA GRANO DE ORO KIWICH 170G", 1,
                new BigDecimal("10.00"), new BigDecimal("7.4270"));
        productRepository.save(product);
        Optional<Product> actualProduct = productRepository.findById(id);

        assertThat(actualProduct).isPresent();
        assertThat(actualProduct.get().getId().getCode()).isEqualTo(id.getCode());
    }
}
