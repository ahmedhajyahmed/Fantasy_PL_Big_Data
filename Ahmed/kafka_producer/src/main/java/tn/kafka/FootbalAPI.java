package tn.kafka;




//        OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder()
//                .url("https://v3.football.api-sports.io/leagues?country=England")
//                .get()
//                .addHeader("x-rapidapi-host", "v3.football.api-sports.io")
//                .addHeader("x-rapidapi-key", "f71b5bfa25e83e8bf7fab16d57addaf3")
//                .build();
//                Response response = client.newCall(request).execute();
//
//                System.out.println(response.body().string());

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class FootbalAPI {

    String host;
    String key;
    OkHttpClient client;


    public FootbalAPI(){
        this.host = "v3.football.api-sports.io";
        this.key = "f71b5bfa25e83e8bf7fab16d57addaf3";
        this.client = new OkHttpClient();
    }

    public String getPLLiveMatchs(){
        try {
            Request request = new Request.Builder()
                    .url("https://v3.football.api-sports.io/fixtures?live=all&league=39")
                    .get()
                    .addHeader("x-rapidapi-host", this.host)
                    .addHeader("x-rapidapi-key", this.key)
                    .build();
            return this.client.newCall(request).execute().body().string();

        }
        catch (IOException exception){
            System.out.println(exception);
            return "call failed";
        }
    }

    public String getPLStatistics(String id){
        try {
//            "/fixtures/statistics?fixture=215662&team=463"
            Request request = new Request.Builder()
                    .url("https://v3.football.api-sports.io/fixtures/statistics?fixture="+ id)
                    .get()
                    .addHeader("x-rapidapi-host", this.host)
                    .addHeader("x-rapidapi-key", this.key)
                    .build();
            return this.client.newCall(request).execute().body().string();

        }
        catch (IOException exception){
            System.out.println(exception);
            return "call failed";
        }
    }


}
