package cn.lzxz1234.encrypt.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import cn.lzxz1234.encrypt.vo.RSAPair;

public class RSAKeyGenerator {

    public static RSAPair generate() throws Exception {
        
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(512);
        KeyPair pair = gen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) pair.getPublic();
        return new RSAPair(Base64.encodes(privateKey.getEncoded()), 
                Base64.encodes(publicKey.getEncoded()));
    }
    
}
