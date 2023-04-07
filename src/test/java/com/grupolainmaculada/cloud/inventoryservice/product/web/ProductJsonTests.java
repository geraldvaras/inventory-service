package com.grupolainmaculada.cloud.inventoryservice.product.web;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class ProductJsonTests {

    @Autowired
    private JacksonTester<Product> json;

    @Test
    void testSerialize() throws Exception {
        var productId = ProductId.of("002", "001", "30012312");
        var product = new Product(productId, "PEPSI 300ML",
                new BigDecimal("3.12"), new BigDecimal("2.34"));
        var jsonContent = json.write(product);
        assertThat(jsonContent).extractingJsonPathStringValue("@.id.code", "30012312")
                .isEqualTo(product.id().code());
        assertThat(jsonContent).extractingJsonPathStringValue("@.description", product.description());
    }

    @Test
    void testDeserialize() throws IOException {
        var content = """
                {
                   "id": {
                     "organizationId": "002",
                     "branchId": "001",
                     "code": "30012312"
                   },
                   "description": "PEPSI 300ML",
                   "unitPrice": "3.30",
                   "unitCost": "2.39"
                 }
                """;
        var productId = ProductId.of("002", "001", "30012312");
        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo(new Product(productId, "PEPSI 300ML",
                        new BigDecimal("3.30"), new BigDecimal("2.39")));
    }
}
