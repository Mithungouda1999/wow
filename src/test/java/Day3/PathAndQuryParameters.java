package Day3;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

public class PathAndQuryParameters {
	
	
	@Test
	void testPathAndQuryParameters() {
		
		
		//https://reqres.in/api/users?page=2$id=5
		given()
		.pathParam("mypath", "users")
		.queryParam("page", 2)
		.queryParam("id", 5)
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
