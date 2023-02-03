package shop.mtcoding.blog.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReq {
    // inner class, static : 외부에서 접근 가능
    public static class JoinReqDto {
        private String username;
        private String password;
        private String email;
    }
}
