package test.MOAIS.user;

import test.MOAIS.common.exception.CustomException;
import test.MOAIS.user.request.UserLoginReq;
import test.MOAIS.user.request.UserSingUpReq;

public interface UserService {
    int signUp(UserSingUpReq userSingUpReq);
    String auth(UserLoginReq userLoginReq) throws CustomException;
}
