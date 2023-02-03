package shop.mtcoding.blog.handler.ex;

//JVM 이 실행되고 일어나는 excep 은 모두 runtime excep
public class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg); // 부모 RuntimeExce 에게 넘기기
    }
}
