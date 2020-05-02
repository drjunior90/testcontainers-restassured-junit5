package com.danieljr.testcontainers.demo;

import static com.danieljr.testcontainers.demo.BaseIT.Resources.V1_CUSTOMERS_ENDPOINT;
import static com.danieljr.testcontainers.demo.testdata.TestData.createCustomer;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.danieljr.testcontainers.demo.dto.Customer;
import com.danieljr.testcontainers.demo.infrastructure.annotation.IT;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@IT
public class CustomerIT extends BaseIT {

    @Test
    void shouldSaveCustomer() {
        // given
        Customer customer = createCustomer();

        final RequestSpecification requestSpecification = given()
                .log().all()
                .contentType(APPLICATION_JSON_VALUE)
                .body(customer);

        // when
        final Response response = requestSpecification
                .when()
                .post(V1_CUSTOMERS_ENDPOINT.build());

        // then
        final Customer customerResponse = response
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .contentType(APPLICATION_JSON_VALUE)
                .extract().response().as(Customer.class);

        assertThat(customerResponse.getCustomerId()).isNotEmpty();
        assertThat(customerResponse.getFirstName()).isEqualTo(customer.getFirstName());
        assertThat(customerResponse.getLastName()).isEqualTo(customer.getLastName());
        assertThat(customerResponse.getAge()).isEqualTo(customer.getAge());
    }
}
