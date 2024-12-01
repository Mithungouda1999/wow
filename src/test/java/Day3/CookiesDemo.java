package Day3;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CookiesDemo {
	
	
	@Test(priority = 1)
	void testCookies() {
		given()
		
		.when()
		.get("https://google.com/")
		.then()
		.cookie("AEC","github.com ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOMqqnkVzrm0SdG6UOoqKLsabgH5C9okWi0dh2l9GKJl")

		.log().all();
	}

	@Test(priority = 2)
	void getCookiesInfo() {
		
		Response res=given()
		.when()
		.get("https://google.com/");
		
		//get single cookies info
	//	String cookie_value=res.getCookie("AEC");
		//System.out.println("Value of cookies is "+cookie_value);
		
		//get all cookies info
                Map<String,String>cookies_values=res.getCookies();
               // System.out.println(cookies_values.keySet());
                
                for(String k:cookies_values.keySet()) {
                	String cookies_value=res.getCookie(k);
                	System.out.println(k+"   "+cookies_value);
                }
	}
}
