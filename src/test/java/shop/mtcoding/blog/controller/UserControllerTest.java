package shop.mtcoding.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
/*
 * SpringBootTest는 통합테스트 (실제 환경과 동일하게 Bean이 생성됨)
 * @AutoConfigureMockMvc는 MOCK 환경의 IOC 컨테이너에 MockMvc Bean이 생성됨
 */

@AutoConfigureMockMvc // @WebMvc 안에 들어가 있음, 안적어주면 DI가 안됨
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void join_test() throws Exception {
        // given
        String requestBody = "username=ssar&password=1234&email=ssar@nate.com";

        // when
        ResultActions resultActions = mvc.perform(post("/join").content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE));

        // then
        resultActions.andExpect(status().is3xxRedirection());
    }
}
