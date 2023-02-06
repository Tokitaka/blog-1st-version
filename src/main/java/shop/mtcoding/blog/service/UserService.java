package shop.mtcoding.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.blog.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.blog.model.User;

@Service
public class UserService {
    @Transactional
    public int 회원가입(JoinReqDto joinReqDto) {
        // username 중복체크 (더블체크) , 역할 분담 할 것
        return 1;
    }

    public User 로그인(LoginReqDto loginReqDto) {

        User user = new User();
        user.setId(1);
        user.setUsername("ssar");
        user.setPassword("1234");
        user.setEmail("ssar@nate.com");
        return user;
    }

}
