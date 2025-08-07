package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endponts.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	@Test
	public void setupData() {
		faker = new Faker();
		userPayload =new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setUsername(faker.name().username());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	
	@Test(priority = 1)
	public void testPostUser() {
		Response responce = UserEndPoint.createUser(userPayload);
		responce.then().log().all();
		Assert.assertEquals(responce.statusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testgetUser() {
		Response responce = UserEndPoint.getUser(this.userPayload.getUsername());
		responce.then().log().all();
		Assert.assertEquals(responce.statusCode(), 200);
	}
	
	@Test(priority = 3)
	
	public void testUpdateUser() {
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setEmail(faker.internet().emailAddress());
		Response response = UserEndPoint.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
		Response responceAfter = UserEndPoint.getUser(this.userPayload.getUsername());
		responceAfter.then().log().all();
		Assert.assertEquals(responceAfter.statusCode(), 200);
	}
	
	@Test(priority = 4)
	
	public void deleteUser() {
		Response responce = UserEndPoint.deleteUser(this.userPayload.getUsername());
		
		responce.then().log().all();
		Assert.assertEquals(responce.getStatusCode(), 200);
	}
	
}
