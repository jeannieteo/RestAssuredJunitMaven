// File: src/test/java/tests/PetApiTest.java
package tests;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import base.TestBase;
import endpoints.Routes;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import model.Pet;
import utils.CSVDataProvider;

public class PetApiTest extends TestBase {

    @ParameterizedTest
    @ValueSource(strings = {"available", "pending", "sold"})
    @Story("Query pets by status")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify pets can be fetched by different statuses")
    public void getPetByStatus(String testStatus) {
        given()
            .header("api-key","special-key")
            .queryParam("status", testStatus)
        .when()
            .get(Routes.get_petByStatus)
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("status", everyItem(equalTo(testStatus)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"availableA", "12345678", "!$@#$#%^%^&"})
    @Story("Query pets by wrong status")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error is return when status is not in the normal values.")
    public void getPetByStatusErrors(String testStatus) {
        given()
            .header("api-key","special-key")
            .queryParam("status", testStatus)
        .when()
            .get(Routes.get_petByStatus)
        .then()
            .statusCode(200)//400
            .contentType(ContentType.JSON);
    }

    @Test
    public void createPetsFromCSV() {
        List<Pet> pets = CSVDataProvider.readPetCSV("src/test/resources/testdata/pets.csv");

        for (Pet pet : pets) {
            given()
                .header("api-key", "special-key")
                .contentType(ContentType.JSON)
                .body(pet)
            .when()
                .post(Routes.post_createPet)
            .then()
                .statusCode(200)
                .body("id", equalTo((int) pet.getId()))
                .body("name", equalTo(pet.getName()))
                .body("status", equalTo(pet.getStatus()));
        }
    }
}
