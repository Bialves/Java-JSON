import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Carro> lista = new ArrayList<>(); // Instancia dos objetos e da lista
        lista.add(new Carro("Fiat", "amarelo", "XXX-000"));
        lista.add(new Carro("Audi", "cinza", "XXX-111"));
        lista.add(new Carro("BMW", "preto", "XXX-222"));

        Gson gson = new Gson(); // Classe de manipulação objetos Java x JSON
        String listaCarrosJSON = gson.toJson(lista); // Converte os objetos em JSON (retorna na forma String)

        try (FileWriter writer = new FileWriter("teste.json")) {
            // Escreve o JSON no arquivo
            writer.write(listaCarrosJSON);

            // Encerra o modo de gravação
            writer.close();

            // Inicia o modo de leitura
            FileReader reader = new FileReader("teste.json");

            // Para conversão de JSON para List, ArrayList, etc... necessária a classe Type
            Type listaTipoCarro = new TypeToken<ArrayList<Carro>>(){}.getType();

            // Lê o JSON no arquivo e converte em objetos do tipo Carro
            ArrayList<Carro> objs = gson.fromJson(reader, listaTipoCarro);

            for(Carro car : objs) {
                System.out.println(car.toString()); // Imprime as informações recuperadas
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }
}