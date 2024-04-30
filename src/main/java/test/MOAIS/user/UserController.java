package test.MOAIS.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.MOAIS.user.request.UserSingUpReq;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @PostMapping("")
    public ResponseEntity<String> signUp(@RequestBody UserSingUpReq userSingUpReq) {
        int result = userService.signUp(userSingUpReq);
        if(result==0){
            return new ResponseEntity<>("이미 가입된 회원입니다.", HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
        }
    }
}
