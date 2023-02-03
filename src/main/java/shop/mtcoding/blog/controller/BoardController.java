package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.model.BoardRepository;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.util.Script;

@Controller
public class BoardController {

    @Autowired
    BoardRepository boarRepository;

    @Autowired
    HttpSession session;

    @GetMapping({ "/", "/board" })
    public String home() {
        return "board/main";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id) {
        return "board/detail";
    }

    @GetMapping("/board/{id}/writeForm")
    public String writeForm(@PathVariable int id) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/loginForm";
        }
        return "board/saveForm";
    }

    @PostMapping("/board")
    public String saveForm(String title, String content) {
        User principal = (User) session.getAttribute("principal");
        int userId = principal.getId();
        int result = boarRepository.insert(title, content, userId);
        if (result != 1) {
            return Script.href("저장에 실패하였습니다.", "/board/saveForm");
        }
        return "redirect:/";

    }
}
