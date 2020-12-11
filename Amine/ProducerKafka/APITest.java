public class Main {
    public static void main(String[] args) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://live-score-api.p.rapidapi.com/scores/live.json?secret=ALISEiueMNCjBg7MpyrKEMrMmV4KDkSd&key=a9qFk6kH7ztioHg8&competition_id=2"))
                .header("x-rapidapi-key", "6bed02f917mshb77f3485b82330cp19bfe0jsna444c1cbf716")
                .header("x-rapidapi-host", "live-score-api.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}