package com.estoquespig.App.utils;
import java.security.MessageDigest;
import java.math.BigInteger;

public class EncoderPassword {
    public static String toMD5(String pass) {
        try{
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes(), 0, pass.length());
            
            return new BigInteger(1,m.digest()).toString(16);
        
        } catch(Exception e) { return e.getMessage(); }
	}
}
