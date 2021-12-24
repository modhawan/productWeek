package ProductweekAPI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.opencsv.CSVReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.apache.logging.log4j.LogManager.getLogger;


public class Customer_API extends Constants {
    private  static Logger log=  getLogger(Customer_API.class.getName());

    //Annotated method is executed before the execution of all test cases

    public void report_Setup() {
        Logger log = getLogger("Loggers");
        RestAssured.useRelaxedHTTPSValidation();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreportAPI.html");
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Verify Data is readed or not", "To Verify datas are added");
        extent.flush();
        log.info("----Loggers-----");

    }





    @Test
    public static void post_regestration() {

        Logger log = getLogger("Loggers");
        RestAssured.useRelaxedHTTPSValidation();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Customer_Regestration_Report.html");
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Verifying the Regestration content type", "To Verify regestration ");
        extent.flush();
        log.info("----Loggers-----");


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
                    map.put("firstname", record[0]);
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
            Logger log = getLogger("Loggers");

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Customer_login_Report.html");
            // create ExtentReports and attach reporter(s)
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            // creates a toggle for the given test, adds all log events under it
            ExtentTest test = extent.createTest("Checking the content type og login", "To Verify datas ");
            extent.flush();
            log.info("----Loggers-----");

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
