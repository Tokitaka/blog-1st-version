package shop.mtcoding.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.board.BoardReq.BoardSaveReqDto;

@Service
public class BoardService {
    @Transactional
    public int 글쓰기(BoardSaveReqDto boardSaveReqDto) {
        return 1;
    }
}
