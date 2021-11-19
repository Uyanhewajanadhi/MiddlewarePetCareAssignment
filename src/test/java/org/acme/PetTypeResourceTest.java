package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PetTypeResourceTest {
    @Test
    public void testGetPetTypes() {
        given()
                .when().get("/v1/petTypes")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetPetTypeById() {
        given()
                .when().get("/v1/petTypes/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testAddPetTypeEndpoint() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\t\"petTypeId\":1,\n" +
                        "\t\"name\":\"Cat\",\n" +
                        "}")
                .when().post("/petTypes")
                .then()
                .assertThat()
                .statusCode(404);

    }

    @Test
    void testDeletePetType() {
        given()
                .header("Content-Type", "application/json")
                .when().delete("/petTypes/1")
                .then()
                .assertThat()
                .statusCode(404);
    }
}
