
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Currency;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        try {
            String key = "51786f614839ece5ea42cc38";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://v6.exchangerate-api.com/v6/" + key + "/latest/USD"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double arsRate = conversionRates.get("ARS").getAsDouble();
            double brlRate = conversionRates.get("BRL").getAsDouble();
            double clpRate = conversionRates.get("CLP").getAsDouble();

            Scanner usuario = new Scanner(System.in);
            Boolean flag = true;

            while (flag) {
                System.out.println("Tasa ARS: " + arsRate+ "\n"+
                        "Tasa BRL: "+ brlRate + "\n"+
                        "Tasa CLP: " + clpRate
                );
                System.out.println();
                System.out.println("Ingrese una opción (1, 2, 3) o 'salir' para terminar:"+ "\n"+"1- Pesos Argentinos"
                + "\n"+"2- Real Brasileño"+"\n"+ "3- Pesos Chilenos");
                String opcion = usuario.nextLine();

                switch (opcion) {
                    case "1":
                        System.out.println("Cuantos USD quieres cambiar por Pesos argentinos?");
                        var opcion2 = usuario.nextLine();

                        var cambio1 = parseInt(opcion2) * arsRate;
                        System.out.println("Compraste: $"+ cambio1+"ARS");
                        System.out.println();
                        break;
                    case "2":
                        System.out.println("Cuantos USD quieres cambiar por Real Brasileño?");
                        var opcion3 = usuario.nextLine();

                        var cambio2 = parseInt(opcion3) * brlRate;
                        System.out.println("Compraste: $"+ cambio2+"BRL");
                        System.out.println();
                        break;
                    case "3":
                        System.out.println("Cuantos USD quieres cambiar por Pesos Chilenos?");
                        var opcion4 = usuario.nextLine();

                        var cambio3 = parseInt(opcion4) * clpRate;
                        System.out.println("Compraste: $"+ cambio3+"CLP");
                        System.out.println();
                        break;
                    case "salir":
                        System.out.println("Saliendo del programa...");
                        flag = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }

            usuario.close();

        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}