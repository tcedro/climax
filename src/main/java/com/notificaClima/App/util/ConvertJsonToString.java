package com.notificaClima.App.util;

import java.io.BufferedReader;
import java.io.IOException;

public class ConvertJsonToString {
    public static String apply(BufferedReader buffereReader) throws IOException {
        String resposta, jsonString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonString += resposta;
        }
        return jsonString;
    }

}