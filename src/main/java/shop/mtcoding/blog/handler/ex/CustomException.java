package shop.mtcoding.blog.handler.ex;

//JVM 이 실행되고 일어나는 excep 은 모두 runtime excep
public class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg); // 부모 RuntimeExce 에게 넘기기, 부모의 생성자라고 이해하기
        // 이미 Runtime 을 상속받았는데 msg를 부모에게 던지는 이유는? Runtime을 생성해야 쓸수있으니까?
        //
    }
}
