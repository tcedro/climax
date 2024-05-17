package com.notificaClima.App.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.notificaClima.App.models.Address;
import com.notificaClima.App.util.ConvertJsonToString;

import ch.qos.logback.classic.pattern.Util;

@Service
public class ViaCepApiService {
    public Address searchCep(String cep){
        String endURL = "https://viacep.com.br/ws/" + cep + "/json/";
        try{
            URL url = new URL(endURL);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setDoInput(true);
            try {
                BufferedReader buff = new BufferedReader(new InputStreamReader((conexao.getInputStream()), "utf-8"));
                String convertJsonString = ConvertJsonToString.apply(buff);
                Gson gson = new Gson();
                Address addr = gson.fromJson(convertJsonString, Address.class);
                
                return addr;
            }catch (Exception e) { e.printStackTrace(); }
        } catch(Exception e) {System.err.println(e); }
        
        return null;
    }

}
