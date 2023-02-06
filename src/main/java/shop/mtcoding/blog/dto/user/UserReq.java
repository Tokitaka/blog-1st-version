package shop.mtcoding.blog.dto.user;

import lombok.Getter;
import lombok.Setter;

public class UserReq {
    @Getter
    @Setter
    // inner class, static : 외부에서 접근 가능
    public static class JoinReqDto {
        private String username;
        private String password;
        private String email;
    }

    @Getter
    @Setter
    // inner class, static : 외부에서 접근 가능
    public static class LoginReqDto {
        private String username;
        private String password;
    }
}

// record 객체