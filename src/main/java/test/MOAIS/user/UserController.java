package test.MOAIS.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping("/sign_up")
    public String hello() {
        return "Hello, World!";
    }
}
