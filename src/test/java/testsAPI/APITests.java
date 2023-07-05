package testsAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class APITests {

    @Test(dataProvider = "apiHealthStatusData")
    public void checkHealthStatusOnPages(String apiEndpoint, Integer expectedStatusCode) {
        Response response = RestAssured.get(apiEndpoint);

        Integer responseStatusCode = response.getStatusCode();
        Assert.assertEquals(responseStatusCode, expectedStatusCode, "Response code is different than " + expectedStatusCode);

        System.out.println("Url: " + apiEndpoint + " with responseStatusCode: " + responseStatusCode);
    }

    @DataProvider(name = "apiHealthStatusData")
    public Object[][] apiHealthStatusData() {
        Object[][] testData = {
                {"https://automationexercise.com/", 200},
                {"https://automationexercise.com/products", 200},
                {"https://automationexercise.com/view_cart", 200},
                {"https://automationexercise.com/login", 200},
                {"https://automationexercise.com/test_cases", 200},
                {"https://automationexercise.com/contact_us", 200},
                {"https://automationexercise.com/api_list", 200},
                {"https://automationexercise.com/api/productsList", 200},
                {"https://automationexercise.com/api/brandsList", 200}
        };

        return testData;
    }
}
