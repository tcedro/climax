package com.notificaClima.App.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.notificaClima.App.database.AzureConfigDataBase;

@RestController
public class DAO {
    @Autowired
    Environment env;

    AzureConfigDataBase azureConfig;
    protected Connection connection = null;
    
    public DAO () {
        // azureConfig =new AzureConfigDataBase();
        connection = null;
    }
    public boolean connect() {
        boolean status=false;
        try {
            System.out.println(env.getProperty("spring.datasource.url"));
            System.out.println(azureConfig.toString());
            connection = DriverManager.getConnection(azureConfig.getAzureUrl(), azureConfig.getUserName(), azureConfig.getPassword());
            status = (connection == null);
        
            System.out.println("Conexão efetuada com o postgres!");
        
        } catch (SQLException e) { System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage()); }

        return status;
    }

    public boolean close() {
		boolean status = false;
		
		try {
			connection.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public static String toMD5(String senha) throws Exception {
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0, senha.length());
		return new BigInteger(1,m.digest()).toString(16);
	}
}
