package cn.lzxz1234.encrypt.utils;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSA {

    public static String encodePrivate(String keys, String data) throws Exception {
        
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodes(keys.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key key = keyFactory.generatePrivate(keySpec);
        
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encodes(cipher.doFinal(data.getBytes("UTF-8")));
    }

    public static String encodePublic(String keys, String data) throws Exception {
        
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodes(keys.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key key = keyFactory.generatePublic(keySpec);
        
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encodes(cipher.doFinal(data.getBytes("UTF-8")));
    }
    
    public static String decodePrivate(String keys, String data) throws Exception {
        
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodes(keys.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key key = keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.decodes(data.getBytes())));
    }
    
    public static String decodePublic(String keys, String data) throws Exception {
        
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodes(keys.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key key = keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.decodes(data.getBytes())));
    }

}
