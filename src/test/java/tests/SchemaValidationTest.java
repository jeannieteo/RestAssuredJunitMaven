package tests;
import org.junit.jupiter.api.Test;

import base.TestBase;
import endpoints.Routes;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTest extends TestBase{

@Test
public void validatePetSchema()   {
    given()
        //.spec(requestSpec)
    .when()
        .get(Routes.get_petById + "3")
    .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("schema/petSchema.json"));
}

@Test
public void validateOrderSchema() {
    given()
        //.spec(requestSpec)
    .when()
        .get(Routes.get_order + "8")
    .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("schema/orderSchema.json"));
    
}

}
