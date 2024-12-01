package Day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LoggingDemo { 
	
    @Test(priority = 1)  // This should be on the method
	void testlogs() {
		given()

		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		
		//.log().all();
		//.log().body();
		//.log().cookies();	
		.log().headers();
	}
}
