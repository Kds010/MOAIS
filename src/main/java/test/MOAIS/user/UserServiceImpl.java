package test.MOAIS.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import test.MOAIS.auth.Authority;
import test.MOAIS.common.exception.CustomException;
import test.MOAIS.common.exception.ErrorResult;
import test.MOAIS.common.security.JwtFilter;
import test.MOAIS.common.security.TokenProvider;
import test.MOAIS.user.request.UserLoginReq;
import test.MOAIS.user.request.UserSingUpReq;
import test.MOAIS.user.response.authTokenRes;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public int signUp(UserSingUpReq userSingUpReq) {
        Optional<Users> users = userRepository.findByUserId(userSingUpReq.getUserId());
        if(users.isPresent()) {
//            log.info("already signUp Id"); return 0;
            throw new CustomException("already signUp Id", HttpStatus.CONFLICT);
        }
        users = userRepository.findByNickname(userSingUpReq.getNickname());
        if(users.isPresent()) {
//            log.info("already using nickname"); return 2;
            throw new CustomException("already using nickname", HttpStatus.CONFLICT);
        }

//        Authority authority = Authority.builder()
//                .authorityName("ROLE_USER")
//                .build();
        String encodedPassword = passwordEncoder.encode(userSingUpReq.getPassword());

        Users newUsers = Users.builder()
                .userId(userSingUpReq.getUserId())
                .nickname(userSingUpReq.getNickname())
                .password(encodedPassword)
//                .password(userSingUpReq.getPassword())
//                .authorities(Collections.singleton(authority))
                .build();

        userRepository.save(newUsers);
        return 1;
    }

    public String auth(UserLoginReq userLoginReq) throws CustomException {
//        Users users = userRepository.findByUserId(userLoginReq.getUserId()).orElseThrow(() -> new CustomException("user not found", HttpStatus.NO_CONTENT));
//        // 비밀번호 암호화 복호화
//        if(!users.getPassword().equals(userLoginReq.getPassword())){
//            throw new CustomException("password mismatch", HttpStatus.BAD_REQUEST);
//        }

//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(users.getUserId(), users.getPassword());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginReq.getUserId(), userLoginReq.getPassword());

        // authenticate 메소드가 실행이 될 때 CustomUserDetailsService class의 loadUserByUsername 메소드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        // 해당 객체를 SecurityContextHolder에 저장하고
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // authentication 객체를 createToken 메소드를 통해서 JWT Token을 생성
        String jwt = tokenProvider.createToken(authentication);

        return jwt;
    }
}
