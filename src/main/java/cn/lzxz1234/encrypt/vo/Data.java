package cn.lzxz1234.encrypt.vo;

public class Data {

    private String sign;
    private String encryptData;
    
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getEncryptData() {
        return encryptData;
    }
    public void setEncryptData(String encryptData) {
        this.encryptData = encryptData;
    }
	@Override
	public String toString() {
		return "{\"sign\":\"" + sign + "\", \"encryptData\":\"" + encryptData + "\"}";
	}
    
}
