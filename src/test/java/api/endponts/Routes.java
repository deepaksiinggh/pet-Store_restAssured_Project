package api.endponts;

public class Routes {

	// base url 
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	
	
	// user model 
	
	public static String postUser = baseUrl+"/user";
	public static String getUser = baseUrl+"/user/{username}";
	public static String updateUser = baseUrl+"/user/{username}";
	public static String deleteUser = baseUrl+"/user/{username}";
	
}
