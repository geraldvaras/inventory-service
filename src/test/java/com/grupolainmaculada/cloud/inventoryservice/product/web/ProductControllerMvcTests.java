package com.grupolainmaculada.cloud.inventoryservice.product.web;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductId;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductNotFoundException;
import com.grupolainmaculada.cloud.inventoryservice.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void whenGetProductNotExistingThenShouldReturn404() throws Exception {
        var productId = new ProductId("002", "001", "30012312");
        given(productService.viewProductDetails(productId))
                .willThrow(ProductNotFoundException.class);
        mockMvc.perform(
                        get("/products/" + productId.code())
                                .header("Organization-Id", productId.organizationId())
                                .header("Branch-Id", productId.branchId())
                )
                .andExpect(status().isNotFound());

    }
}
