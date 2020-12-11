import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

    public class APITest {

        public void call() throws IOException {
            OkHttpClient client = new OkHttpClient();
            Random rand = new Random();
            Request request = new Request.Builder()
                    .url("https://live-score-api.p.rapidapi.com/scores/live.json?secret=ALISEiueMNCjBg7MpyrKEMrMmV4KDkSd&key=a9qFk6kH7ztioHg8&competition_id=2")
                    .get()
                    .addHeader("x-rapidapi-key", "6bed02f917mshb77f3485b82330cp19bfe0jsna444c1cbf716")
                    .addHeader("x-rapidapi-host", "live-score-api.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
           // System.out.println(response.body().string());
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Result.txt", true))) {
                bufferedWriter.write(response.body().string());
                bufferedWriter.newLine();
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }


