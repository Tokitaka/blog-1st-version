package shop.mtcoding.blog.dto.board;

import lombok.Getter;
import lombok.Setter;

public class BoardReq {
    @Getter
    @Setter
    // 인증과 관련된게 아닐땐 상세하게 이름 붙이기
    public static class BoardSaveReqDto {
        private String title;
        private String content;
    }
}
