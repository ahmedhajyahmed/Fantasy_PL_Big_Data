import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

public class DataReporter implements Runnable {

    private static final int NUM_MESSAGES = 10;
    private final String TOPIC;
    private FootballScienceAPI fsAPI;
    private Producer<Long, String> producer;
    //JSONObject jsonMessage;

    public DataReporter(final Producer<Long, String> producer, String TOPIC) {
        this.producer = producer;
        this.TOPIC = TOPIC;
        this.fsAPI= new FootballScienceAPI();
        //this.jsonMessage=new JSONObject();
    }

    public void run() {
        for(int i = 0; i < NUM_MESSAGES; i++) {  
        	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            long time = System.currentTimeMillis();
            
            System.out.println("Data #" + i + " from thread #" + Thread.currentThread().getId());
//            String message=fsAPI.getLiveResults().getBody().toString();
//            String message=fsAPI.getResults("2020-11-9", "2020-11-07").getBody().toString();
            String message="{\"outcome\":\"tie\",\"score\":2,\"score_opposing\":2}";
            System.out.println(message);
            final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(TOPIC, time,  message);
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception != null) {
                        System.out.println(exception);
                        System.exit(1);
                    }
                }
            });
        }
        System.out.println("Finished sending " + NUM_MESSAGES + " messages from thread #" + Thread.currentThread().getId() + "!");
    }
}
