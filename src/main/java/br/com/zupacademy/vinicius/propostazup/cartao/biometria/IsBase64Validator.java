package br.com.zupacademy.vinicius.propostazup.cartao.biometria;

import java.util.Base64;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsBase64Validator implements ConstraintValidator<IsBase64, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value == null) return false;
		
		try {
			String decodificado = new String(Base64.getDecoder().decode(value));
			String codificado = Base64.getEncoder().encodeToString(decodificado.getBytes());
			return value.equals(codificado);
			
		} catch (Exception e) {
			return false;
		}
	}

}
