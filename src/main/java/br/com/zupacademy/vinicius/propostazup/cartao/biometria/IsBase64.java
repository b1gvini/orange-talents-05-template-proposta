package br.com.zupacademy.vinicius.propostazup.cartao.biometria;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IsBase64Validator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsBase64 {

	String message() default "Fingerprint precisa está em formato base64.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
