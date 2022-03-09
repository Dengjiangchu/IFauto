package service;

import bean.UserLoginRep;
import bean.UserLoginReq;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *  登录接口
 */
public interface ILogin {

    @POST("/api/v1/auth/login")
    Call<UserLoginRep> login(@Body() UserLoginReq userLoginReq);
}
