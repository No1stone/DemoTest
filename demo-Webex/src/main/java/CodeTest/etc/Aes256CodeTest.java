package CodeTest.etc;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes256CodeTest {

	public static void main(String[] args) throws Exception{
		String plainText = "jangws1003@kostlab.co.kr";
		String encrypted = encrypt(plainText);
	
		System.out.printf("PLAIN_TEXT:: %s \n", plainText);
		System.out.printf("ENCRYPTED_:: %s \n", encrypted);
		System.out.printf("DECRYPTED_:: %s \n", decrypt(encrypted));
		
		aes256tester tester = new aes256tester(encrypted);
		
		System.out.println("=======================");
		//System.out.println(tester.aesEncode(plainText));
		//System.out.println(tester.aesDecode(encrypted));
		
	}
	
	public static String Alg = "AES/CBC/PKCS5Padding";
	public static String PK= "01234567890123456789012345678901";
	public static String IV = PK.substring(0,16);
	
	public static String encrypt(String plainText) throws Exception{
		
		Cipher cipher = Cipher.getInstance(Alg);
		SecretKeySpec keySpec = new SecretKeySpec(IV.getBytes(), "AES");
		IvParameterSpec ivParamSpec = new IvParameterSpec(IV.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);
				
		
		byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
		
		return Base64.getEncoder().encodeToString(encrypted);
	}
	
	public static String decrypt(String cipherText) throws Exception{
		
		Cipher cipher = Cipher.getInstance(Alg);
		SecretKeySpec keySpec = new SecretKeySpec(IV.getBytes(), "AES");
		IvParameterSpec ivParamSpec = new IvParameterSpec(IV.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, keySpec,ivParamSpec);
		
		byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
		byte[] decrypted = cipher.doFinal(decodedBytes);
		
		return new String(decrypted, "UTF-8");
	}
	//Vw4SK+k6yUrYqxqZHPsBD7XkcbiLBgZc+uEDt7IXEcw=
	//Vw4SK+k6yUrYqxqZHPsBD7XkcbiLBgZc+uEDt7IXEcw=
}
