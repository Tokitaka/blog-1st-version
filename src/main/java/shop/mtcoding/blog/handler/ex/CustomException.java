package shop.mtcoding.blog.handler.ex;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;

import lombok.Getter;

//JVM 이 실행되고 일어나는 excep 은 모두 runtime excep
@Getter
public class CustomException extends RuntimeException {
    private HttpStatus status;// Getter

    public CustomException(String msg, HttpStatus status) {
        super(msg); // 부모 RuntimeExce 에게 넘기기, 부모의 생성자라고 이해하기
        this.status = status;
        // 이미 Runtime 을 상속받았는데 msg를 부모에게 던지는 이유는? Runtime을 생성해야 쓸수있으니까?
        // Throwable(getMessage()) <- Exception(super()) <- RuntimeException(super()) <-
        // CustomException
    }

    public CustomException(String msg) {
        this(msg, HttpStatus.BAD_REQUEST);
        // this 본인의 생성자를 때린 것
    }
}
