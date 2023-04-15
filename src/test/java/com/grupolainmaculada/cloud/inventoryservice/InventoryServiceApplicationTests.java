package com.grupolainmaculada.cloud.inventoryservice;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration")
class InventoryServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;


	@Test
	void whenPostRequestThenProductCreated() {
		var id = ProductId.of("002","002", "001","30012312");
		var expectedProduct = Product.of(id, "PEPSI 300ML", 1,
				new BigDecimal("3.12"), new BigDecimal("2.89"));

		webTestClient
				.post()
				.uri("/products")
				.bodyValue(expectedProduct)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(Product.class).value( actualProduct -> {
					assertThat(actualProduct).isNotNull();
					assertThat(actualProduct.getId().getCode())
							.isEqualTo(expectedProduct.getId().getCode());
				});
	}

}
