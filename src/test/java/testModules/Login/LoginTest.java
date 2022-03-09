package testModules.Login;

import bean.UserLoginRep;
import bean.UserLoginReq;
import center.DateCenter;
import center.UserTokenCenter;
import common.BaseTest;
import common.HttpBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reporter.MyReporter;
import retrofit2.Call;
import retrofit2.Response;
import service.ILogin;

import java.io.IOException;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  登录接口测试类
 */
public class LoginTest extends BaseTest {

    /**
     * 测试数据源
     *
     * @return HashMap<String, String> data []
     */
    @DataProvider(name = "loginData")
    public Object[][] data() {
        // 定义相对testData路径文件
        String file = "login/login.xls";
        DateCenter testcase = new DateCenter();
        return testcase.testData(file);
    }

    @Test(description = "login-test", dataProvider = "loginData", enabled = true)
    public void testLogin(HashMap<String, String> data) throws IOException {
        // 定制报告：详情打印入参
        MyReporter.setDescription(data.toString());

        String username = data.get("username");
        String password = data.get("password");
        // 测试请求
        HttpBase httpBase = new HttpBase(this.getHost());
        ILogin iget = httpBase.create(ILogin.class);
        UserLoginReq userLoginReq = new UserLoginReq();
        userLoginReq.setUsername(username);
        userLoginReq.setPassword(password);
        Call<UserLoginRep> call = iget.login(userLoginReq);
        Response<UserLoginRep> response = call.execute();
        Assert.assertNotNull(response);
        int error_code = response.body().getError_code();
        String token = response.body().getData().getToken();
        // 登录完成后，可以保存token到静态类以备后续其他接口使用
        if (token != null) UserTokenCenter.setToken(token);
        // AssertJ断言示例
        assertThat(data.get("error_code")).isEqualTo(String.valueOf(error_code)).as("error_code不符");
        assertThat(data.get("message")).isEqualTo(response.body().getMessage()).as("message不符");
    }
}
