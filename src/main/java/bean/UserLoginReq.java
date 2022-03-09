package bean;

public class UserLoginReq {

    /**
     *  使用Gson自动生成的请求体类
     */

    private String username;
    private String password;
    private Object captcha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getCaptcha() {
        return captcha;
    }

    public void setCaptcha(Object captcha) {
        this.captcha = captcha;
    }
}
