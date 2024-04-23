package br.com.hcgv.viacep;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {

   public String httpSearch(String cep) {

       // criei o endereco para passar no URI
       URI endereco = URI.create("https://viacep.com.br/ws/" + cep.replace("-", "") + "/json/");

       HttpClient client = HttpClient.newHttpClient();
       HttpRequest request = HttpRequest.newBuilder()
               .uri(endereco)  // passei o link no uri
               .build();

       HttpResponse<String> response = null;
       try {
           response = HttpClient
                   .newHttpClient()
                   .send(request, HttpResponse.BodyHandlers.ofString());

       } catch (IOException | InterruptedException e){
           throw new RuntimeException("Cep não encontrado!");
       }
       String json = response.body();
       return json;  // retornei o response.body
   }
}
