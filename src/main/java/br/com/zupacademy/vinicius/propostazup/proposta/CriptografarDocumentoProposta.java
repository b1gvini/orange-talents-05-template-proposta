package br.com.zupacademy.vinicius.propostazup.proposta;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class CriptografarDocumentoProposta {

	private final static String secret = "shausehuaeueaawu";
	private final static String salt = "3eb46e44e890d234a903f196f4996d98";
	
	@SuppressWarnings("deprecation")
	private static TextEncryptor encryptor =  Encryptors.queryableText(secret, salt);
	
	public static String criptografar(String documento) {
		return encryptor.encrypt(documento);
	}
	public static String descriptografar(String documento) {
		return encryptor.decrypt(documento);
	}
}
