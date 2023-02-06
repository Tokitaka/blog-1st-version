package shop.mtcoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.blog.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional // 걸리면 동기화(동시접속)이 안된다고 생각해 -> 근데 사실은 'write' 동작만 lock 걸림(select no), 메서드 동기화
                   // synchronized 걸면 됨
    public void 회원가입(JoinReqDto joinReqDto) {
        // username 중복체크 (더블체크) , 역할 분담 할 것
        User sameUser = userRepository.findByUsername(joinReqDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }
        // insert -> Transaction 발동 -> lock
        int result = userRepository.insert(joinReqDto.getUsername(), joinReqDto.getPassword(), joinReqDto.getEmail());
        if (result != 1) {
            throw new CustomException("회원가입 실패");
        }
    }

    @Transactional(readOnly = true) // transactional 를 걸면 내 작업이 끝나기 전까지는 외부에서 data가 변경이 되도 그 전의 데이터로 read, select도
                                    // 트랜잭션을 걸어야 하는 이유
    public User 로그인(LoginReqDto loginReqDto) {
        User principal = userRepository.findByUsernameAndPassword(
                loginReqDto.getUsername(), loginReqDto.getPassword());
        // session값 검증은 Service 에서 한다
        if (principal == null) {
            throw new CustomException("유저네임 혹은 패스워드가 잘못 입력되었습니다");
        }
        return principal;
    }

}
