package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.allOf;

@QuarkusTest
public class PetResourceTest {

    @Test
    public void testGetPets() {
        given()
                .when().get("/v1/pets")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetPet() {
        given()
                .when().get("/v1/pets/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testAddPetEndpoint() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\t\"petId\":1,\n" +
                        "\t\"petType\":{\n" +
                        "\t\"petTypeId\":2,\n" +
                        "\t\"name\":\"Dog\"}" +
                        "\n" +
                        "\t\"petName\":\"ScoobyDoo\",\n" +
                        "\t\"petAge\":5\n" +
                        "}")
                .when().post("/pets")
                .then()
                .assertThat()
                .statusCode(404);

    }

    @Test
    void testDeletePet() {
        given()
                .header("Content-Type", "application/json")
                .when().delete("/pets/1")
                .then()
                .assertThat()
                .statusCode(404);
    }

}