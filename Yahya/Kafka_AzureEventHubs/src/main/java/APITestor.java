
public class APITestor {
	public static void main(String[] args) {
		FootballScienceAPI fsAPI=new FootballScienceAPI();
		
		
		// the date format is yy-mm-dd
		// the date interval must be smaller than 8 days
		//System.out.println("Calendar :");
		//System.out.println(fsAPI.getCalendar("2020-11-9", "2020-11-07").getBody());
		//System.out.println("Results :");
		//System.out.println(fsAPI.getResults("2020-11-9", "2020-11-07").getBody());
		System.out.println("Live Results :");
		System.out.println(fsAPI.getLiveResults().getBody());
		
	}

}
