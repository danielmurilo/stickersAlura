import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //http connection to tmdb api - The Movie Database
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI adress = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(adress).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //extracting data 
        var parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);
        

        //showing data
        for (Map<String,String> movie : moviesList) {
            InputStream is = new URL(movie.get("image")).openStream();
            new StickersGenerator().readImg(is, movie.get("title"));
            
        }
    }
}
