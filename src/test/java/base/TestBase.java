// File: src/test/java/base/TestBase.java
package base;

import org.junit.jupiter.api.BeforeAll;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
public class TestBase {
    @BeforeAll
    public static void setUp() {
        //RestAssured.baseURI = System.getProperty("baseUrl", "https://api.example.com");
        RestAssured.filters(new AllureRestAssured());//logs every test to allure
    }
}