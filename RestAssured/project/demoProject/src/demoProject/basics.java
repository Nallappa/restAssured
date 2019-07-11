package demoProject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;;

public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		given().
		        param("query","restaurants+in+Sydney").
		        param("key","AIzaSyBvQaVSi9BjNyfvrU9d6Biw4XdJrVtyXkg").
		        when().
		        get("/maps/api/place/textsearch/json").
		        then().assertThat().
		        statusCode(200).and().contentType(ContentType.JSON).and().
		        body("results[0].name",equalTo("Restaurant Hubert"));
		
		        
		               
	}

}
