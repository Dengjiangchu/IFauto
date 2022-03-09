package interceptor;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/***
 *  请求头拦截器，设置通用请求头
 */
public class HeadersInterceptor implements Interceptor {
    private Headers headers;

    public HeadersInterceptor() {
    }

    /**
     *  传入一个请求头Map,初始化请求头
     * @param headersParams
     */
    public HeadersInterceptor(Map<String, String> headersParams) {
        Headers headers = buildHeaders(headersParams);
        this.headers=headers;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request build = request.newBuilder()
                .headers(headers)
                .build();
        Response response = chain.proceed(build);
        return response;
    }

    public static Headers buildHeaders(Map<String, String> headersParams) {
        Headers headers = null;
        okhttp3.Headers.Builder headersbuilder = new okhttp3.Headers.Builder();
        if (headersParams != null && !headersParams.isEmpty()) {
            Iterator<String> iterator = headersParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next();
                headersbuilder.add(key, headersParams.get(key));
            }
        }
        headers = headersbuilder.build();
        return headers;
    }
}
