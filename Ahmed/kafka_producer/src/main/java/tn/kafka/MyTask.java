package tn.kafka;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {


        FootbalAPI live_api = new FootbalAPI();
        String first_message = live_api.getPLLiveMatchs();
        System.out.println(first_message);

        JSONObject jsonObject = new JSONObject(first_message);
        String id = jsonObject.getJSONArray("response")
                .getJSONObject(0)
                .getJSONObject("fixture")
                .getBigInteger("id").toString();
        System.out.println(id);


        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("api_log.txt", true))) {
            bufferedWriter.write(first_message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println(e);
        }

        FootbalAPI stat_api = new FootbalAPI();
        String message = stat_api.getPLStatistics(id);
        System.out.println(message);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("stat_log.json", true))) {
            bufferedWriter.write(first_message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
