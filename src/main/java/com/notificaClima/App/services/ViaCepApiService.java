package com.notificaClima.App.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.notificaClima.App.entities.AddressEntity;
import com.notificaClima.App.utils.ConvertJsonToString;

@Service
public class ViaCepApiService {
    public AddressEntity searchAddressWithCep(String cep){
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
                AddressEntity addr = gson.fromJson(convertJsonString, AddressEntity.class);
                
                return addr;
            }catch (Exception e) { e.printStackTrace(); }
        } catch(Exception e) {System.err.println(e); }
        
        return null;
    }

}
