package Testing;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class CreateRec_Post {

@Test
   public void PostData01() {

RestAssured.baseURI = "https://petstore.swagger.io/v2";
       RestAssured.registerParser("text/plain", Parser.JSON);

JSONObject Payload = new JSONObject();
Payload.put("id", 3);

JSONObject category = new JSONObject();
category.put("id", 3);
category.put("name", "45");
Payload.put("category", category);

Payload.put("name", "3 dinosaur");

JSONArray photoUrls = new JSONArray();
photoUrls.add("string");
Payload.put("photoUrls", photoUrls);

JSONArray tags = new JSONArray();
JSONObject tag = new JSONObject();
tag.put("id", 0);
tag.put("name", "AD1S");
tags.add(tag);
Payload.put("tags", tags);

Payload.put("status", "available");

Response response = RestAssured.given()
        .header("Content-type", "application/json")
           .when()
                .body(Payload)
                .post("/pet")
           .then()
                .statusCode(200) // Validate the status code
                .extract()
                .response(); // Extract the response

       // Print the response body
       System.out.println("Response Body: " + response.getBody().asString());
       response.then().body("category.name", equalTo("45"));
       
     String id = response.jsonPath().getString("category.name");
 System.out.println("id is=" + id);




}

}