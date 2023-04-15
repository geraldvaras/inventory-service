package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ProductValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var id = ProductId.of("002", "002", "001", "30012312");
        var product = Product.of(id, "Pepsi 300ml", 1, new BigDecimal("3.12"), new BigDecimal("3.15"));
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenUnitPriceIsNegativeThenValidationFails() {
        var id = ProductId.of("002", "002", "001", "30012312");
        var product = Product.of(id, "Pepsi 300ml", 1, new BigDecimal("-3.12"), new BigDecimal("3.15"));
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The unit price must be greater than zero.");
    }

    @Test
    void whenProducCodeDefindButIncorrectFormatThenValidationFails() {
        var id = ProductId.of("002", "002", "001", "A0012312");
        var product = Product.of(id, "Pepsi 300ml", 1, new BigDecimal("3.12"), new BigDecimal("3.15"));
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The product code format must be valid.");

    }
}
