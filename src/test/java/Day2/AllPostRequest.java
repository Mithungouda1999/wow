package Day2;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class AllPostRequest {

	// 1>post request body using Hashmap
	@Test(priority = 1)
	void UsingHashmap() {
       HashMap<String, Object> data = new HashMap<>();
       data.put("Name", "Root");
       data.put("Location", "Uk");
       data.put("Phone", "123456");
       
       String[] CourseArr = {"Java", "C#"};
       data.put("Courses", CourseArr);

       given()
           .contentType("application/json")
           .body(data)
       .when()
           .post("http://localhost:3000/students")  // Changed to HTTP
       .then()
           .statusCode(201)
           .body("Name", equalTo("Root"))
           .body("Location", equalTo("Uk"))
           .body("Phone", equalTo("123456"))
           .body("Courses[0]", equalTo("Java"))
           .body("Courses[1]", equalTo("C#"))
           .header("Content-Type", "application/json; charset=utf-8")
           .log().all();
	}
}
