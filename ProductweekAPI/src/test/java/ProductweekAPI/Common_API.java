package ProductweekAPI;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.logging.log4j.LogManager.getLogger;

public class Common_API extends Constants {


    private  static Logger log=  getLogger(Common_API.class.getName());

    @Test
    public static void customer_get_categorylist() {
        RestAssured.useRelaxedHTTPSValidation();
        Logger log = getLogger("Loggers");

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Common _CategoryList_Report.html");
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Checking the content type of Category List", "Checking the content type of category list");
        extent.flush();
        log.info("----Loggers-----");

        given().
                baseUri(get_new). //Navigating to base url
                when().get(Customer_get_Categorylist_url).   //endpoint of url
                then().
                statusCode(200).contentType("application/json"); //checking status

                  RequestSpecification response= given().baseUri(get_new);

    }

    @Test
    public static void customer_get_productlist(){
        RestAssured.useRelaxedHTTPSValidation();

        Logger log = getLogger("Loggers");

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Common_ProductList_Report.html");
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Checking the content type of the product list", "Checking the content type of Product list");
        extent.flush();
        log.info("----Loggers-----");

        given().
                baseUri(get_new). //Navigating to base url
                when().get(Customer_get_Product_list_url).   //endpoint of url
                then()
                .contentType("application/json"); //checking status

    }



}
