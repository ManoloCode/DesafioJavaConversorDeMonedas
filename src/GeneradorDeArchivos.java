import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivos {
    public void guardarJson(Moneda moneda) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter( moneda.result() + ".Json");
        escritura.write(gson.toJson(moneda));
        escritura.close();
    }
}
