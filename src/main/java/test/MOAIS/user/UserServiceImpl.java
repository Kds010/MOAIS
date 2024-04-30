package test.MOAIS.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import test.MOAIS.user.request.UserSingUpReq;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Transactional
    public int signUp(UserSingUpReq userSingUpReq){
        Optional<Users> users = userRepository.findByUserId(userSingUpReq.getUserId());
        if(users.isPresent()) { log.info("이미 가입된 회원 아이디입니다."); return 0; }

        Users newUsers = Users.builder()
                .userId(userSingUpReq.getUserId())
                .nickName(userSingUpReq.getNickName())
                .passWord(userSingUpReq.getPassWord())
                .build();

        userRepository.save(newUsers);
        return 1;
    }
}
