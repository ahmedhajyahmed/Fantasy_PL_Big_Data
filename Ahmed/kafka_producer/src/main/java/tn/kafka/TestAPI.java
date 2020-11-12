package tn.kafka;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class TestAPI {

    public TestAPI(){

    }

    public static void  main(String[] args) throws Exception{

        if(args.length ==0){
            System.out.println("please specify the topic name");
            return;
        }

        String topicName = args[0].toString();
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://v3.football.api-sports.io/leagues?country=England")
                .get()
                .addHeader("x-rapidapi-host", "v3.football.api-sports.io")
                .addHeader("x-rapidapi-key", "f71b5bfa25e83e8bf7fab16d57addaf3")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        for(int i=0; i<10; i++)
            producer.send(new ProducerRecord<String, String>(topicName,
                    response.toString(),
                    response.body().string()));
            System.out.println("response sent successfully");
            producer.close();

    }
}
