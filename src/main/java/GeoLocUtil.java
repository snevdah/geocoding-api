import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GeoLocUtil {
    private static final String API_KEY = "f897a99d971b5eef57be6fafa0d83239";
    private static final String BASE_URL_NAME = "http://api.openweathermap.org/geo/1.0/direct";
    private static final String BASE_URL_ZIP = "http://api.openweathermap.org/geo/1.0/zip";

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("using: java GeoLocUtil <locations...>");
            return;
        }

        for (String location : args){
            try {
                String result = fetchLocation(location);
                System.out.println(result);
            } catch (IOException | InterruptedException e){
                System.out.println("Error to find data for location: " + location);
                e.printStackTrace();
            }
        }
    }

    public static String fetchLocation (String query) throws IOException, InterruptedException {
        String formattedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String url = query.matches("\\d+")
                ? BASE_URL_ZIP + "?zip=" + formattedQuery + "&appid=" + API_KEY
                : BASE_URL_NAME + "?q=" + formattedQuery + ",US&appid=" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Request URL: " + url);
        System.out.println("Response: " + response.body());

        if (response.statusCode() != 200){
            return "Error to find data, status code is: " + response.statusCode();
        }
//        return parseResponse(query, response.body());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.body());

        if (root.isArray() && root.size() > 0) {
            JsonNode data = root.get(0);
            if (data.has("lat") && data.has("lon")) {
                return String.format("Latitude: %.4f, Longitude: %.4f, Name: %s",
                        data.get("lat").asDouble(),
                        data.get("lon").asDouble(),
                        data.get("name").asText("Unknown"));
            }
        } else if (root.has("lat") && root.has("lon")) {
            return String.format("Latitude: %.4f, Longitude: %.4f, Name: %s",
                    root.get("lat").asDouble(),
                    root.get("lon").asDouble(),
                    root.has("name") ? root.get("name").asText("Unknown") : "Unknown");
        }
        if (root.isArray() && root.size() == 0) {
            return "No data found for location: " + query;
        }

        return "No data found for location: " + query;

    }

    private static String parseResponse (String query, String responseBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseBody);

        if (root.isArray() && root.size() > 0){
            JsonNode data = root.get(0);
            String name = data.get("name").asText("");
            double lat = data.get("lat").asDouble();
            double lon = data.get("lon").asDouble();
            return String.format("Location: %s, Latitude: %.4f, Longitude: %.4f, Name: %s", query, lat, lon, name);
        } else if (root.has("lat") && root.has("lon")) {
            double lat = root.get("lat").asDouble();
            double lon = root.get("lon").asDouble();
            String name = root.has("name") ? root.get("name").asText("") : "Unknown";
            return String.format("Location: %s, Latitude: %.4f, Longitude: %.4f, Name: %s", query, lat, lon, name);
        }

        return "No data for - " + query;
    }
}
