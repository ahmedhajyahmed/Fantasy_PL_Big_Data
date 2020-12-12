import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class FootballScienceAPI {
	public String xRapidAPIKey;
	public String xRapidAPIHost;
	public FootballScienceAPI() {
		this.xRapidAPIHost="stroccoli-futbol-science-v1.p.rapidapi.com";
		this.xRapidAPIKey="84db601062mshb685823d9b93996p118d11jsn050912c38b22";
		
	}
	
	//date in this format yy/mm/dd
	public HttpResponse getCalendar(String startDate,String endDate) {
		try {
			HttpResponse response=Unirest.get("https://stroccoli-futbol-science-v1.p.rapidapi.com/s1/calendar/"+startDate+"/"+endDate+"?tournament_name=English%20Premier%20League")
					.header("x-rapidapi-key", this.xRapidAPIKey)
					.header("x-rapidapi-host", this.xRapidAPIHost)
					.asString();
			return response;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			System.out.println("API call failed");
			return null;
		}

	}

	public HttpResponse getResults(String startDate, String endDate) {
		try {
			HttpResponse<String> response = Unirest.get("https://stroccoli-futbol-science-v1.p.rapidapi.com/s1/results/"+startDate+"/"+endDate+"?tournament_name=English%20Premier%20League")
					.header("x-rapidapi-key", this.xRapidAPIKey)
					.header("x-rapidapi-host", this.xRapidAPIHost)
					.asString();
			return response;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			System.out.println("API call failed");
			return null;
		}
	}

	public HttpResponse getLiveResults() {
		try {
			HttpResponse<JsonNode> response = Unirest.get("https://stroccoli-futbol-science-v1.p.rapidapi.com/s2/live")
					.header("x-rapidapi-key", this.xRapidAPIKey)
					.header("x-rapidapi-host", this.xRapidAPIHost)
					.asJson();
			return response;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			System.out.println("API call failed");
			return null;
		}
	}



}
