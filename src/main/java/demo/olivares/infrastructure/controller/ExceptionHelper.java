package demo.olivares.infrastructure.controller;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import demo.olivares.domain.exception.OperationException;
import demo.olivares.infrastructure.controller.operation.OperationController;

@ControllerAdvice(assignableTypes = { OperationController.class })
public class ExceptionHelper extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { OperationException.class })
	public ResponseEntity<Object> handleDomainException(OperationException ex, WebRequest request) {
		return handleExceptionInternal(ex, Collections.singleton(ex.getMessage()), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
