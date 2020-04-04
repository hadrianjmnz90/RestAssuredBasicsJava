import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;

public class ReUsableMethods {

	
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 =new JsonPath(response);
		return js1;
	}

	public static JsonPath rawToJsonResponse(Response response)
	{
		JsonPath js1 =new JsonPath((File) response);
		return js1;
	}
}
