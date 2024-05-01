package test.MOAIS.user;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import test.MOAIS.common.exception.CustomException;
//import test.MOAIS.common.security.JwtFilter;
import test.MOAIS.user.request.UserLoginReq;
import test.MOAIS.user.request.UserSingUpReq;
import test.MOAIS.user.response.authTokenRes;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @ResponseBody
    @PostMapping("")
    public ResponseEntity<String> signUp(@RequestBody UserSingUpReq userSingUpReq) {
//        int result = userService.signUp(userSingUpReq);
        userService.signUp(userSingUpReq);
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
//        if(result==1){
//            return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
//            // 코드 return 하는것으로 변경
//        }else if(result == 0){
//            return new ResponseEntity<>("이미 가입된 회원입니다.", HttpStatus.CONFLICT);
//            // 코드 return 하는것으로 변경
//        }else {
//            return new ResponseEntity<>("중복된 닉네임입니다.", HttpStatus.CONFLICT);
//            // 코드 return 하는것으로 변경
//        }
    }

    @ResponseBody
    @PostMapping("/auth")
    public ResponseEntity<authTokenRes> auth(@RequestBody UserLoginReq userLoginReq) {
        try{
            String jwt = userService.auth(userLoginReq);
            HttpHeaders httpHeaders = new HttpHeaders();
            // response header에 jwt token에 넣어줌
//            httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
            return new ResponseEntity<>(new authTokenRes(jwt), httpHeaders, HttpStatus.OK);
        }catch (CustomException ce){
            throw new ResponseStatusException(ce.getHttpStatus(), ce.getMessage());
        }
    }
}
