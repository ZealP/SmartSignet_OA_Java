package com.smartsignet.smartsignet_oa_library_java.net.intercepter;

import android.text.TextUtils;

import com.jxtele.sealonline_library.net.http.interceptor.BaseDynamicInterceptor;
import com.smartsignet.smartsignet_oa_library_java.utils.CommonUtil;
import com.smartsignet.smartsignet_oa_library_java.utils.MD5;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class SignIntercepter extends BaseDynamicInterceptor<SignIntercepter> {

    String mOpenId = "";
    String mSecret = "";

    public SignIntercepter(String openId, String secretKey) {
        this.mOpenId = openId;
        this.mSecret = secretKey;
    }

    /**
     * 全部请求签名字段使用GET\POST形式传递
     *
     * @param chain
     * @return
     * @throws IOException
     */
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (isSign()) {
            if (request.method() == "GET")
                request = addParam(request);
        }
        return chain.proceed(request);
    }

    /**
     * GET拦截器
     *
     * @param oldRequest
     * @return
     */
    private Request addParam(Request oldRequest) {
        HttpUrl.Builder build = oldRequest.url().newBuilder();
        String timeStamp = CommonUtil.formatTimeStamp(System.currentTimeMillis());

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("timestamp", timeStamp);

        for (String key : map.keySet()) {
            build.setEncodedQueryParameter(key, map.get(key));
        }

        Request newRequest = oldRequest.newBuilder()
                .url(build.build())
                .build();

        HashMap<String, List<String>> rootMap = new HashMap<>();

        for (String key : newRequest.url().queryParameterNames()) {
            if (!TextUtils.isEmpty(key))
                rootMap.put(key, newRequest.url().queryParameterValues(key));
        }

        String digest = encodeReqSecretString(rootMap);

        String url = newRequest.url().toString();
        url += ("&sign=" + digest);

        return newRequest.newBuilder().url(url).build();
    }

    /**
     * 签名加密字段
     */
    private String encodeReqSecretString(HashMap<String, List<String>> map) {
        StringBuffer mMapResult = new StringBuffer();
        Object[] key_arr = map.keySet().toArray();
        Arrays.sort(key_arr);
        for (Object key : key_arr) {
            mMapResult.append(key + "=" + (map.size() > 1 ? map.get(key).get(0) : ""));
        }
        mMapResult.append(mSecret);
        return MD5.encodeMD5(mMapResult.toString()).toUpperCase();
    }

    @Override
    public TreeMap<String, String> dynamic(TreeMap<String, String> dynamicMap) {
        return null;
    }
}
