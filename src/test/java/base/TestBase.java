// File: src/test/java/base/TestBase.java
package base;

import org.junit.jupiter.api.BeforeAll;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestBase {
    public static RequestSpecification requestSpec;

    @BeforeAll
    public static void setUp() {
        //RestAssured.baseURI = System.getProperty("baseUrl", "https://api.example.com");
        RestAssured.filters(new AllureRestAssured());//logs every test to allure
        requestSpec = new RequestSpecBuilder()
        .setContentType(ContentType.JSON)
        .addHeader("api-key", "special-key")
        .build();
    }


}