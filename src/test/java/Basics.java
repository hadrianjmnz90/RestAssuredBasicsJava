import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import org.testng.annotations.Test;

public class Basics {
  //  @Test
    public void basics() {
        // TODO Auto-generated method stub
// validate if Add Place API is workimg as expected
        //Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
		System.out.println("***CREATE PLACE ***");
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String placeId = js.getString("place_id");

        System.out.println(placeId);
		System.out.println("***UPDATE PLACE ***");
        //Update Place
        String newAddress = "Jesus Maria, Mexico";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(payload.UpdateAddress(placeId, newAddress)).
                when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        //Get Place
		System.out.println("***GET PLACE ***");
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, newAddress);

        //Delete place
		System.out.println("***DELETE PLACE ***");
String deletePlaceResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.DeletePlace(placeId))
		.when().delete("/maps/api/place/delete/json").then().assertThat().log().all().statusCode(200)
		.body("status", equalTo("OK"))
		.extract().response().asString();
		System.out.println(deletePlaceResponse);
JsonPath jsonPath = ReUsableMethods.rawToJson(deletePlaceResponse);
//		System.out.println(jsonPath);
		String placeIdAfterDelete = jsonPath.getString("place_id");

		System.out.println("after delete " + placeIdAfterDelete);
    }

    @Test
	public void getPlace(){
  // try this method to verify if the place deleted above was actually deleted
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//
		String placeId = "4eea11ef468699f77fd2f097d5639599";
		System.out.println("***GET PLACE ***");
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.queryParam("place_id", placeId)
				.when().get("maps/api/place/get/json")
				.then().assertThat().log().all().statusCode(404)
				.body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists")).
						extract().response().asString();
	//	System.out.println(getPlaceResponse);

	}

}
