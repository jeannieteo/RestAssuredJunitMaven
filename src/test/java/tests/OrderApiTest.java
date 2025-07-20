package tests;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

import base.TestBase;
import endpoints.Routes;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import model.Order;
import utils.CSVDataProvider;

public class OrderApiTest extends TestBase{
    
    @Story("Query order by orderID")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify order can be fetched by orderID")
    @Test
    public void getOrderByID() {
        given()
            .spec(requestSpec)
        .when()
            .get(Routes.get_orderById + "2")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("id", equalTo(2));
    }

    @Story("Post Order to Store/Order")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify order can be post to STore Order")
    @Test
    public void postOrder(){
        List<Order> orders = CSVDataProvider.readOrderCSV("src/test/resources/testdata/order.csv");
        for (Order order: orders)  {
            given()
                .spec(requestSpec)
                .body(order)
                //.body("{ \"id\": 10, \"petId\": 1, \"quantity\": 2, \"shipDate\": \"2023-10-01T00:00:00.000+00:00\", \"status\": \"placed\", \"complete\": true }")
            .when()
                .post(Routes.get_orderById)
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
                //.body("id", equalTo(order.getId()));
                //.body("petId", equalTo(order.getPetId()))
                //.body("quantity", equalTo(order.getQuantity()))
                //.body("status", equalTo(order.getSTatus()))
                //.body("complete", equalTo(order.getComplete()));
        }
    }



}
