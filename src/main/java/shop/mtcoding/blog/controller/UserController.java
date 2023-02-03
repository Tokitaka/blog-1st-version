package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.blog.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;
import shop.mtcoding.blog.service.UserService;
import shop.mtcoding.blog.util.Script;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

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

    @ResponseBody
    @PostMapping("/login")
    public String login(String username, String password) {
        User principal = userRepository.findByUsernameAndPassword(username, password);
        if (principal == null) {
            return Script.back("로그인실패");
        }
        session.setAttribute("principal", principal);
        return Script.href("/");
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}