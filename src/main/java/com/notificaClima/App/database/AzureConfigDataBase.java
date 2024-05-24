package com.notificaClima.App.database;

import org.springframework.beans.factory.annotation.Value;

public class AzureConfigDataBase {
    @Value("spring.datasource.url")
    private String azureUrl;
    @Value("spring.datasource.username")
    private String userName;
    @Value("spring.datasource.password")
    private String password;
    public String getAzureUrl() {
        return azureUrl;
    }
    public void setAzureUrl(String azureUrl) {
        this.azureUrl = azureUrl;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "AzureConfigDataBase [azureUrl=" + azureUrl + ", userName=" + userName + ", password=" + password + "]";
    }
    
}
