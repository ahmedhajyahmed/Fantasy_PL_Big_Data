import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class APITestor {
	public static void main(String[] args) {
		FootballScienceAPI fsAPI=new FootballScienceAPI();
		
		
		// the date format is yy-mm-dd
		// the date interval must be smaller than 8 days
		//System.out.println("Calendar :");
		//System.out.println(fsAPI.getCalendar("2020-11-9", "2020-11-07").getBody());
		//System.out.println("Results :");
		//System.out.println(fsAPI.getResults("2020-11-9", "2020-11-07").getBody());
		
		//System.out.println("Live Results :");
		//System.out.println(fsAPI.getLiveResults().getBody());
	    

//		try {
//			 
//            // Constructs a FileWriter given a file name, using the platform's default charset
//			
//			FileWriter fileWriter = new FileWriter("C:\\Users\\ASUS\\Desktop\\Projects\\Fantasy_PL_Big_Data\\Yahya\\Kafka_AzureEventHubs\\src\\main\\resources\\myMatches.json",true);
//			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
//				InputStream inputStream = fsAPI.getLiveResults().getRawBody();
//				BufferedInputStream bis = new BufferedInputStream(inputStream);
//				ByteArrayOutputStream buf = new ByteArrayOutputStream();
//				int result = bis.read();
//				while(result != -1) {
//				    buf.write((byte) result);
//				    result = bis.read();
//				}
//
//			String rawJson = buf.toString("UTF-8");
//			System.out.println(rawJson);
//            bufferedWriter.write(rawJson);
//            bufferedWriter.newLine();
//            
//        } catch (IOException e) {
//        	System.out.println("error");
//            e.printStackTrace();
// 
//        }
		
		
		
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\ASUS\\Desktop\\Projects\\Fantasy_PL_Big_Data\\Yahya\\Kafka_AzureEventHubs\\src\\main\\resources\\myMatches.json", true))) {
			InputStream inputStream = fsAPI.getLiveResults().getRawBody();
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			ByteArrayOutputStream buf = new ByteArrayOutputStream();
			int result = bis.read();
			while(result != -1) {
			    buf.write((byte) result);
			    result = bis.read();
			}

			String rawJson = buf.toString("UTF-8");
			System.out.println(rawJson);
		    bufferedWriter.write(rawJson);
		    bufferedWriter.newLine();
		} catch (IOException e) {
		    System.out.println(e);
		}
		
		


}}
