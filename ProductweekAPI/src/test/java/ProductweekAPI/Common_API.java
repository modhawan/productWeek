package ProductweekAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Common_API extends Constants {

    @Test
    public static void customer_get_categorylist() {
        RestAssured.useRelaxedHTTPSValidation();
        given().
                baseUri(get_new). //Navigating to base url
                when().get(Customer_get_Categorylist_url).   //endpoint of url
                then().
                statusCode(200).contentType("application/json"); //checking status

                  RequestSpecification response= given().baseUri(get_new);
                  // JSONArray Json= new JSONArray(response.toString());
                  //System.out.println(response.toString());



    }

    @Test
    public static void customer_get_productlist(){
        RestAssured.useRelaxedHTTPSValidation();
        given().
                baseUri(get_new). //Navigating to base url
                when().get(Customer_get_Product_list_url).   //endpoint of url
                then()
                .contentType("application/json"); //checking status


    }



}
