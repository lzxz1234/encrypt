package cn.lzxz1234.encrypt.api;

import java.util.UUID;

import cn.lzxz1234.encrypt.utils.AES;
import cn.lzxz1234.encrypt.utils.RSA;
import cn.lzxz1234.encrypt.utils.StringUtils;
import cn.lzxz1234.encrypt.vo.Data;

class Base {

    private final String selfPrivateKey;
    private final String otherPublicKey;
    
    public Base(String selfPrivateKey, String otherPublicKey) {
        
        this.selfPrivateKey = selfPrivateKey;
        this.otherPublicKey = otherPublicKey;
    }
    
    public Data encode(String data) throws Exception {
        
        Data msg = new Data();
        String key1 = UUID.randomUUID().toString();
        String key2 = UUID.randomUUID().toString();
        String aeskey = StringUtils.left(key1, 8) + StringUtils.left(key2, 8);
        msg.setEncryptData(AES.encrypts(data, aeskey));
        msg.setSign(RSA.encodePrivate(selfPrivateKey, key1) + "\r\n" + RSA.encodePublic(otherPublicKey, key2));
        return msg;
    }
    
    public String decode(Data msg) throws Exception {
        
        String[] keys = msg.getSign().split("[\\r\\n]+");
        String key1 = RSA.decodePublic(otherPublicKey, keys[0]);
        String key2 = RSA.decodePrivate(selfPrivateKey, keys[1]);
        String aeskey = StringUtils.left(key1, 8) + StringUtils.left(key2, 8);
        return AES.decrypts(msg.getEncryptData(), aeskey);
    }
}
