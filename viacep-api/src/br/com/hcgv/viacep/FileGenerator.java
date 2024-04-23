package br.com.hcgv.viacep;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {

    public void generator(String convertJson, String cep) throws IOException {
        FileWriter file = new FileWriter(cep + ".json");
        file.write(convertJson); // escrevi num arquivo
        file.close();
    }
}
