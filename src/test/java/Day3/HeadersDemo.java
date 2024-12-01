package Day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
//	@Test(priority = 1)
	void testHeaders() {
		given()
		
		.when()
		.get("https://google.com/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.and()
		.header("Server","gws" );
		
	}
	
	
	@Test(priority = 2)
	void getHeaders() {
		
		
		Response res= given()
		
		                 .when()
		                        .get("https://google.com/");
		
       //get single header info
		 	String headervalue=res.getHeader("Content-Type");
		 	System.out.println("the value of Content-Type:"+headervalue);
		
	}
	
	@Test(priority = 2)
	void getAllHeaders() {
		
		
		Response res= given()
		
		                 .when()
		                        .get("https://google.com/");
		
		Headers myheaders=res.getHeaders();
		
		for(Header hd:myheaders) {
			System.out.println(hd.getName()+"  "+hd.getValue());
		}
		}
	
	
	
	
	
	
	
	
}
