import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoneda {

    public Moneda conversionMoneda(String moneda, String segundaMoneda, Double cantidad){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/76013aa4a140cf1018d8fb65/pair/"+moneda+"/"+segundaMoneda+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String>  response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa conversión.");
        }


    }
}
