package jp.co.fostone.springwebsys.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerAdvise {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String exp(Exception e) {
		return this.getClass().getSimpleName() + ":" + e.getMessage();
	}
}
