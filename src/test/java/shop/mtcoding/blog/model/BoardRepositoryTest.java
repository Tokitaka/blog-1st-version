package shop.mtcoding.blog.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.blog.dto.board.BoardResp.BoardMainRespDto;

// <복잡한 쿼리 Test>
// filter, controller, dispatcher Servlet 안뜨고 DB관련된 애들만 띄우는거, mybatis spring boot starter test 다운로드 받기
// R - my - DB
@MybatisTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findAllWithUser_test() throws Exception {
        // given
        // DB에서 떙겨오기
        ObjectMapper om = new ObjectMapper(); // Json으로 바꿔서 보기, Spring은 ObjectMapper 제공 Json으로 파싱하기, 자바는 지선
        // when
        List<BoardMainRespDto> boardMainRespDto = boardRepository.findAllWithUser();
        String responseBody = om.writeValueAsString(boardMainRespDto);
        // then
        assertThat(boardMainRespDto.get(5).getUsername()).isEqualTo("love");
    }
}
