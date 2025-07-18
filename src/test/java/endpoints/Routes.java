// File: src/test/java/endpoints/Routes.java
package endpoints;

public class Routes {
    public static String base_url = "https://petstore.swagger.io/v2";
    public static String get_petByStatus = base_url+ "/pet/findByStatus";
    public static String post_createPet = base_url+ "/pet";
    public static String get_petById = base_url+ "/pet/";
    public static String delete_petById = base_url+ "/pet/{petId}";
    public static String get_order = base_url + "/store/order/";
}

