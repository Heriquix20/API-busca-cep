package br.com.hcgv.viacep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{

        Scanner sc = new Scanner(System.in);
        FileGenerator file = new FileGenerator();
        Http http = new Http();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            System.out.println("Digite um CEP para a busca: ");
            String cep = sc.nextLine();

            String json = http.httpSearch(cep); // chamei o http para buscar o cep
            Endereco end = gson.fromJson(json, Endereco.class); // peguei o response body e integrei na classe endereco
            String convertJson = gson.toJson(end); // converti o endereço de gson em json

            file.generator(convertJson, cep);

            System.out.println(convertJson); // imprimi o endereco em json formatado pelo pretty

        } catch (JsonSyntaxException | IllegalArgumentException e) {
            System.out.println("Ocorreu um erro! Verifique o cep se está digitado corretamente");
        }

        sc.close();
    }
}