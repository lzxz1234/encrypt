package cn.lzxz1234.encrypt.vo;

public class RSAPair {

    private String privateKey;
    private String publicKey;
    
    public RSAPair() {
        
    }
    
    public RSAPair(String privateKey, String publicKey) {
        
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }
    
    public String getPrivateKey() {
        return privateKey;
    }
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
    public String getPublicKey() {
        return publicKey;
    }
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    
    
    
}
