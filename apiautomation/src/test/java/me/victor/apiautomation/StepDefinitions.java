package me.victor.apiautomation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.TreeMap;

public class StepDefinitions {

	@SuppressWarnings("serial")
	private static final Map<String, String> countryCodes = new TreeMap<String, String>() {
		{
			put("Germany", "DE");
			put("United Kingdom", "GB");
		}
	};

	private String country, city;

	private Response response;

	@Given("the city bikes endpoint")
	public void setUp() {
		RestAssured.baseURI = "http://api.citybik.es";

		response = given().contentType(ContentType.JSON).accept(ContentType.JSON).get("v2/networks").then().extract()
				.response();
	}

	@Then("I verify that the city of {string} is in the country {string}")
	public void i_want_to_verify_that_the_city_is_in_country(String city, String countryName) {
		this.city = city;
		this.country = countryCodes.get(countryName);

		response.then().assertThat().body("networks.location",
				hasItem(allOf(hasEntry("city", city), hasEntry("country", country))));
	}

	@Then("their their corresponding latitude and longitude coordinates are returned")
	public void return_their_corresponded_latitude_and_longitude() {
		Map<String, Object> location = response.then().extract().jsonPath()
				.getMap("networks.find { n ->  n.location.city == '" + city + "' && n.location.country == '" + country
						+ "'}.location");
		System.out.println("Latitude :" + location.get("latitude"));
		System.out.println("Longitude :" + location.get("longitude"));
	}

}
