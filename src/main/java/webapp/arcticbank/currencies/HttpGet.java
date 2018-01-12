package webapp.arcticbank.currencies;

import org.apache.log4j.Logger;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import webapp.arcticbank.servlets.CreditCardRegistrationServlet;

public class HttpGet {
	
	Logger logger = Logger.getLogger(HttpGet.class);
	
	public static Rates getCurrencies(){
		
		HttpResponse<JsonNode> jsonResponse;
		JSON currencies = null;
		try {
			jsonResponse = Unirest.get("https://v3.exchangerate-api.com/bulk/44cab6f64fc9b591fe709378/USD")
					  .header("result", "result")
					  .asJson();
			
			currencies = com.alibaba.fastjson.JSON.parseObject(jsonResponse.getBody().toString(), JSON.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return (currencies!=null) ? currencies.getRates() : null;
		
	}

}
