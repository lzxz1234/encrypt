package cn.lzxz1234.encrypt.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static byte[] ivk = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    public static String encrypts(String data, String key) throws Exception {
        
        try {
            byte[] encryptData = encrypt(data.getBytes("UTF-8"), key.getBytes());
            return Base64.encodes(encryptData);
        } catch (Exception e) {
            throw new RuntimeException("用" + key + "加密" + data + "失败", e);
        }
    }
    
    public static String decrypts(String data, String key) throws Exception {
        
        try {
            byte[] encryptData = Base64.decodes(data.getBytes("UTF-8"));
            return new String(decrypt(encryptData, key.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("用" + key + "解密" + data + "失败", e);
        }
    }
    
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {

    	IvParameterSpec zeroIv = new IvParameterSpec(ivk);  
        SecretKeySpec seckey = new SecretKeySpec(key, "AES");  
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
        cipher.init(Cipher.ENCRYPT_MODE, seckey, zeroIv);  
        byte[] encryptedData = cipher.doFinal(data);
        return encryptedData;
    }

    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {

    	IvParameterSpec zeroIv = new IvParameterSpec(ivk);  
        SecretKeySpec seckey = new SecretKeySpec(key, "AES");  
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
        cipher.init(Cipher.DECRYPT_MODE, seckey, zeroIv);  
        byte[] encryptedData = cipher.doFinal(data);
        return encryptedData;
    }
    
}
