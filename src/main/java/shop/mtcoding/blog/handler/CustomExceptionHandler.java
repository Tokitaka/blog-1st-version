package shop.mtcoding.blog.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.util.Script;

//Excep 전용 컨트롤러
@RestControllerAdvice
public class CustomExceptionHandler {
    // NullPointException < - RuntimeException
    // RumtimeException 터지면 Spring 이 아래 메소드 실행 -> 제어한다는 뜻
    // @ExceptionHandler(RuntimeException.class) -> 부모
    // CustomException 만 제어 하겠다
    @ExceptionHandler(CustomException.class)
    public String customException(CustomException e) {
        return Script.back(e.getMessage());
    }
}
