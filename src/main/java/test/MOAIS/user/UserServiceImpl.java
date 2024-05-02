package test.MOAIS.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import test.MOAIS.auth.Authority;
import test.MOAIS.common.exception.CustomException;
import test.MOAIS.common.security.TokenProvider;
import test.MOAIS.user.request.UserLoginReq;
import test.MOAIS.user.request.UserSingUpReq;

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
            throw new CustomException("already signUp Id", HttpStatus.CONFLICT);
        }
        users = userRepository.findByNicknameAndDeleted(userSingUpReq.getNickname(), false);
        if(users.isPresent()) {
            throw new CustomException("already using nickname", HttpStatus.CONFLICT);
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        String encodedPassword = passwordEncoder.encode(userSingUpReq.getPassword());

        Users newUsers = Users.builder()
                .userId(userSingUpReq.getUserId())
                .nickname(userSingUpReq.getNickname())
                .password(encodedPassword)
                .authorities(Collections.singleton(authority))
                .build();

        userRepository.save(newUsers);
        return 1;
    }

    public String auth(UserLoginReq userLoginReq) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginReq.getUserId(), userLoginReq.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);

        return jwt;
    }

    @Override
    @Transactional
    public void deleteUser(Long id, String userId) {
        Users user = userRepository.findById(id).orElseThrow(() -> new CustomException("dose not exist that user", HttpStatus.NO_CONTENT));

        if(!user.getUserId().equals(userId)){
            throw new CustomException("잘못된 탈퇴 요청입니다.", HttpStatus.BAD_REQUEST);
        }

        user.setDeleted(true);
        userRepository.save(user);
    }
}
