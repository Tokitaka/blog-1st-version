package shop.mtcoding.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> customException(CustomException e) {
        return new ResponseEntity<>(Script.back(e.getMessage()), HttpStatus.BAD_REQUEST); //400
        //file X, data 리턴할때만 씀 new ResponseEntity<>(body, http상태코드)
    }
}
