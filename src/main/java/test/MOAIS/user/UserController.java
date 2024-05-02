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
import test.MOAIS.common.security.SecurityUtil;
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
        userService.signUp(userSingUpReq);
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/auth")
    public ResponseEntity<authTokenRes> auth(@RequestBody UserLoginReq userLoginReq) {
        try{
            String jwt = userService.auth(userLoginReq);
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<>(new authTokenRes(jwt), httpHeaders, HttpStatus.OK);
        }catch (CustomException ce){
            throw new ResponseStatusException(ce.getHttpStatus(), ce.getMessage());
        }
    }

    @ResponseBody
    @PostMapping("/loginStateTest")
    public String test() {
        return SecurityUtil.getCurrentUsername();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String userId = SecurityUtil.getCurrentUsername();
        userService.deleteUser(id, userId);
        return new ResponseEntity<>("회원 탈퇴", HttpStatus.OK);
    }
}
