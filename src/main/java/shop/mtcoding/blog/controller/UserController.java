package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.blog.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;
import shop.mtcoding.blog.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;
    // 역할 분담 : controller 는 Service를 거쳐서 Repository에 접근
    // 하므로 의존성 주입.

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) {

        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            // NullPointException잡아주기 가 선행되고 isEmpty(front의 입력 문제, "" 공백같은거)
            throw new CustomException("username을 작성해주세요");
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new CustomException("password을 작성해주세요");
        }
        if (joinReqDto.getEmail() == null || joinReqDto.getEmail().isEmpty()) {
            throw new CustomException("email을 작성해주세요");
        }

        int result = userService.회원가입(joinReqDto);
        if (result != 1) {
            throw new CustomException("회원가입 실패");
        }
        return "redirect:/loginForm";
    }

    @PostMapping("/login")
    public String login(LoginReqDto loginReqDto) {
        if (loginReqDto.getUsername() == null || loginReqDto.getUsername().isEmpty()) {
            // NullPointException잡아주기 가 선행되고 isEmpty(front의 입력 문제, "" 공백같은거)
            throw new CustomException("username을 작성해주세요");
        }
        if (loginReqDto.getPassword() == null || loginReqDto.getPassword().isEmpty()) {
            throw new CustomException("password을 작성해주세요");
        }
        User principal = userService.로그인(loginReqDto);

        // 검증 : Service에서 null return 한 후, 책임 + 검증
        session.setAttribute("principal", principal);
        return "redirect:/";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}