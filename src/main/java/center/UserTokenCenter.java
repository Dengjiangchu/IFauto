package center;

import interceptor.HeadersInterceptor;

import java.util.HashMap;
import java.util.Map;


/**
 * 用户token工具类
 */
public class UserTokenCenter {
    private static String token;

    public static String getToken() {
        return token == null ? "" : token;
    }

    public static void setToken(String token) {
        UserTokenCenter.token = token;
    }

    /**
     * 封装通用请求头，返回带token和通用参数的HeadersInterceptor
     *
     * @return 通用的请求头HeadersInterceptor
     */
    public static HeadersInterceptor getHeadersInterceptor() {
        Map<String, String> headersParams = new HashMap<>();
        headersParams.put("cookie", "token=" + getToken());
        headersParams.put("other-parameters", "parameter");
        return new HeadersInterceptor(headersParams);
    }

    /**
     * 封装通用请求头参数，返回带token的通用请求头参数Map，便于添加自定义headers
     *
     * @return 通用请求头参数Map
     */
    public static Map<String, String> getheadersParams() {
        Map<String, String> headersParams = new HashMap<>();
        headersParams.put("cookie", "token=" + getToken());
        headersParams.put("other-parameters", "parameter");
        return headersParams;
    }
}
