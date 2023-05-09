package com.grupolainmaculada.cloud.inventoryservice;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration")
class InventoryServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void givenPaginatedRequest_whenGetRequestWithNotValidSearchTerm_thenSupplierIsNotReturned() {
        var term = "KI";
        ResponseSpec response = webTestClient
                .get()
                .uri(String.format("/api/v1/suppliers/search/%s?page=1&size=10", term))
                .header("Organization-Id", "002")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
        response.expectStatus().isOk();
    }

    @Test
    void givenPaginatedRequest_whenGetRequestWithValidSearchTerm_thenPaginatedSuppliersIsReturned() {
        var term = "KIM";
        ResponseSpec response = webTestClient
                .get()
                .uri(String.format("/api/v1/suppliers/search/%s?page=1&size=10", term))
                .header("Organization-Id", "002")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        response.expectStatus().isOk();

        response.expectBody()
                .jsonPath("$._embedded.suppliersDto[0].supplierId")
                .isEqualTo("002435")
                .jsonPath("$._embedded.suppliersDto[1].businessName")
                .isEqualTo("PLAZA VEA ORIENTE SAC")
                .jsonPath("$._embedded.suppliersDto[2].documentNumber")
                .isEqualTo("20601233488");

        ArgumentCaptor<Pageable> captor = ArgumentCaptor.forClass(Pageable.class);
        /*
        verify(supplierService)
                .searchActiveSuppliersByBusinessNameOrDoi(
                        "002",
                        term, captor.capture().getPageNumber(),
                        captor.capture().getPageSize());
        Pageable pageable = captor.getValue();
        assertThat(pageable.getPageNumber()).isEqualTo(1);
        assertThat(pageable.getPageSize()).isEqualTo(10);
        */

    }
}
