package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Main7 {
	
	private static final String BAS_URL = "http://api.currencylayer.com";
	private static final String API_KEY = "2e4baadf5c5ae6ba436f53ae5558107f";
	private static final String SOURCE = "USD";
	private static final String CURRENCIES = "EUR";

	public static void main(String[] args) {
		
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			URL url = new URL(BAS_URL + "/live?access_key=" + API_KEY + "&source=" + SOURCE + "&currenicies=" + CURRENCIES);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(con.getInputStream()));
			
			JsonObject result = gson.fromJson(br, JsonObject.class);
			
			System.out.println(result);
			
			if(result.get("success").getAsBoolean()) {
				System.out.println();
			
				double kurs = result.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble();
				System.out.println("Kurs je: " + kurs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
