package Day1;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

/*
given()
{content type,set cookies,add auth,add param,set header info..}
when()
{get,post,put,delete}
then()
{validate status code,extract response,extract headers, cookies & response body..... }


*/

public class HTTPRequestS {
	int id;

	@Test(priority = 1)
	void getUsers() {
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200)
				// .body("size()", greaterThan(0));
				.body("page", equalTo(2)) // Use `equalTo()` for matching values
				.log().all();

	}

	@Test(priority = 2)
	void CreateUser() {

		HashMap data = new HashMap();
		data.put("name", "pavan");
		data.put("job", "trainer");

		id = given().contentType("application/Json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
//	       .then()
//	       .statusCode(201)
//	         .log().all();
	}

	@Test(priority = 3, dependsOnMethods = { "CreateUser" })
	void UpadateUser() {
		HashMap data = new HashMap();
		data.put("name", "john");
		data.put("job", "teacher");

		given().contentType("application/Json").body(data)

				.when().put("https://reqres.in/api/users/" + id)

				.then().statusCode(200).log().all();
	}

	@Test(priority = 4)
	void DeteteUser() {
		given()

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();
	}

}
