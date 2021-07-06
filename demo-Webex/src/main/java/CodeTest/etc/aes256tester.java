package CodeTest.etc;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
 
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;


public class aes256tester {
	private String iv;
    private Key keySpec;
    
    public aes256tester(String key) throws UnsupportedEncodingException {
        this.iv = key.substring(0, 16);
        
        System.out.println("키 서브스트링  == "+ key.substring(0, 16));
        
        byte[] keyBytes = new byte[16];
        System.out.println("keyBytes == "+keyBytes);
        
        byte[] b = key.getBytes("UTF-8");
        System.out.println("key.getBytes(\"UTF-8\") == "+key.getBytes("UTF-8"));
        
        int len = b.length;
        System.out.println("len == "+len);
        
        if (len > keyBytes.length) {
        	System.out.println("keyBytes.length == "+keyBytes.length);
            len = keyBytes.length;
            System.out.println("len == "+len);
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        
 
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
 
        System.out.println("keySpec == "+keySpec);
        
        this.keySpec = keySpec;
    }
    
 
    // 암호화
    public String aesEncode(String str) throws java.io.UnsupportedEncodingException, 
                                                    NoSuchAlgorithmException, 
                                                    NoSuchPaddingException, 
                                                    InvalidKeyException, 
                                                    InvalidAlgorithmParameterException, 
                                                    IllegalBlockSizeException, 
                                                    BadPaddingException {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
 
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.encodeBase64(encrypted));
 
        return enStr;
    }
 
    //복호화
    public String aesDecode(String str) throws java.io.UnsupportedEncodingException,
                                                        NoSuchAlgorithmException,
                                                        NoSuchPaddingException, 
                                                        InvalidKeyException, 
                                                        InvalidAlgorithmParameterException,
                                                        IllegalBlockSizeException, 
                                                        BadPaddingException {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));
 
        byte[] byteStr = Base64.decodeBase64(str.getBytes());
 
        return new String(c.doFinal(byteStr),"UTF-8");
    }

}
