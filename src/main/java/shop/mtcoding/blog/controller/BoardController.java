package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.dto.board.BoardReq.BoardSaveReqDto;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.BoardRepository;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.service.BoardService;
import shop.mtcoding.blog.util.Script;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

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

    // <글쓰기>
    // form 이 나오는거 아니면 메서드에 form 쓰지마
    @PostMapping("/board")
    public String save(BoardSaveReqDto boardSaveReqDto) {
        // 1. 인증 체크 (나중엔 filter로 처리, 인증이 안되는데 controller까지 올필요 없지)
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            throw new CustomException("인증이 되지 않았습니다", HttpStatus.UNAUTHORIZED); // 401 걸어주기
        } // 현재 : 400 -> 인증오류 : 401(Unauthorized) 를 줘야 한다, 403(forbidden) : 권한 없음

        // 2. 유효성 검사
        if (boardSaveReqDto.getTitle() == null || boardSaveReqDto.getTitle().isEmpty()) {
            // NullPointException잡아주기 가 선행되고 isEmpty(front의 입력 문제, "" 공백같은거)
            throw new CustomException("title을 작성해주세요");
        }
        if (boardSaveReqDto.getContent() == null || boardSaveReqDto.getContent().isEmpty()) {
            throw new CustomException("content을 작성해주세요");
        }
        if (boardSaveReqDto.getTitle().length() > 100) {
            throw new CustomException("title의 길이가 100자 이하여야 합니다");
        }
        // 3. Service에 넘기기
        boardService.글쓰기(boardSaveReqDto, principal.getId());

        return "redirect:/";

    }
}
