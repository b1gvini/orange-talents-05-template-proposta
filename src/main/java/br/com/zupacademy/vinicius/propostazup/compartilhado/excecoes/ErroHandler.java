package br.com.zupacademy.vinicius.propostazup.compartilhado.excecoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDTO> handle(MethodArgumentNotValidException exception) {
		List<ErroDTO> dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDTO erro = new ErroDTO(e.getField(), mensagem);
			dto.add(erro);

		});

		return dto;
	}

	@ExceptionHandler(ExcecaoGenerica.class)
	public ResponseEntity<?> handleGenerico(ExcecaoGenerica exception) {
		HttpStatus status = exception.getStatus();
		ErroDTO erro = new ErroDTO(exception.getMessage());
		return ResponseEntity.status(status).body(erro);
	}

}
