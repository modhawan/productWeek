package ProductweekAPI;
import com.opencsv.CSVReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;


public class Customer_API extends Constants {

    @Test
    public static void post_regestration() {
        RestAssured.useRelaxedHTTPSValidation();

            RestAssured.baseURI = Basic_URL;

            //Using Exception Handling
            try {
                CSVReader csv_Reader = new CSVReader(new FileReader(Customer_regestration_filepath), ',');
                //intialize array of string
                String[] record;
                int statusCode = 0;

               // logg.info("Reading CSV File");

                while ((record = csv_Reader.readNext()) != null) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("firestname", record[0]);
                    map.put("lastname", record[1]);
                    map.put("email", record[2]);
                    map.put("mobilenumber", record[3]);
                    map.put("password", record[4]);
                    //adding authorization in header
                    Response response = given().headers("Authorization", "Bearer " + bearer_token).
                            contentType(ContentType.JSON).
                            when().body(map).
                            post(Post_customer_Registration_url).
                            then().extract().response();
                    statusCode = response.getStatusCode();
                    //printing  response on console
                    System.out.println(response.getBody().asString());
                }
                System.out.println("The status code recieved: " + statusCode);
               // logg.info("The status code recieved: " + statusCode);
            }
            catch (IOException e) {
                e.printStackTrace();

            }

        }
        @Test
       public static void get_login(){
            RestAssured.useRelaxedHTTPSValidation();
            given().
                    baseUri(get_new). //Navigating to base url
                    when().get(Customer_get_login).   //endpoint of url
                    then()
                    .contentType("application/json");//checking status
                    //checking email and password is null/not
                    //assertThat().
                      //      body("email", greaterThan(0)).
                    //body("email", notNullValue()).
                    //body("password", notNullValue());





        }
    }
