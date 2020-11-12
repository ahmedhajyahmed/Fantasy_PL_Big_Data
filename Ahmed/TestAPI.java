// using  java http
HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://api-football-beta.p.rapidapi.com/timezone"))
		.header("x-rapidapi-key", "d5b9a587abmshae09f051870782ep1bcd3bjsnd5cfbb650ebb")
		.header("x-rapidapi-host", "api-football-beta.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
// using java OkHttpClient
OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
	.url("https://api-football-beta.p.rapidapi.com/timezone")
	.get()
	.addHeader("x-rapidapi-key", "d5b9a587abmshae09f051870782ep1bcd3bjsnd5cfbb650ebb")
	.addHeader("x-rapidapi-host", "api-football-beta.p.rapidapi.com")
	.build();

Response response = client.newCall(request).execute();