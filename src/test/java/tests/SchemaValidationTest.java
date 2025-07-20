package tests;
import org.junit.jupiter.api.Test;

import base.TestBase;
import endpoints.Routes;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.response.Response;

public class SchemaValidationTest extends TestBase{

@Test
public void validatePetSchema()   {
    int[] idsToTry = {1,2,3,4,5,6,7,8,9,10};
    for(int idtry : idsToTry)  {
        Response response = 
        given()
            .spec(requestSpec)
        .when()
            .get(Routes.get_petById + idtry)
        .then()
            //.statusCode(200)
            .extract().response();
            //.body(matchesJsonSchemaInClasspath("schema/petSchema.json"));
        if(response.getStatusCode() == 200) {
            response.then().body(matchesJsonSchemaInClasspath("schema/petSchema.json"));
            break;
        }
    }
}

@Test
public void validateOrderSchema() {
    int[] idsToTry = {1,2,3,4,5,6,7,8,9,10};
    for(int idtry : idsToTry)  {
        Response response = 
        given()
            //.spec(requestSpec)
        .when()
            .get(Routes.get_orderById + "2")
        .then()
            //.statusCode(200)
            .extract().response();
            
    if (response.getStatusCode() == 200)  {
        response.then().body(matchesJsonSchemaInClasspath("schema/orderSchema.json"));
        break;
    }
        
    }//end for

}

}
