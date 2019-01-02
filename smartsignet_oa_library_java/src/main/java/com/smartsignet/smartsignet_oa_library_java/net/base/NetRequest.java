package com.smartsignet.smartsignet_oa_library_java.net.base;

import com.jxtele.sealonline_library.net.http.request.GetRequest;
import com.smartsignet.smartsignet_oa_library_java.net.custom.CustomGet;

/**
 * Created by zealPeng on 2017/9/26.
 */

public class NetRequest {

    private static NetRequest mNet;

    private NetRequest() {
    }

    public static NetRequest getInstance() {
        if (mNet == null) {
            synchronized (NetRequest.class) {
                if (mNet == null) {
                    mNet = new NetRequest();
                }
            }
        }
        return mNet;
    }

    /**
     * GET请求体
     *
     * @param url
     * @param signFlag
     * @return
     */
    public GetRequest doGetReq(String url, Boolean signFlag) {
        GetRequest mReq = new CustomGet(url).connectTimeout(15 * 1000);
        if (signFlag)
            mReq.accessToken(true).sign(true).timeStamp(true);
        else
            mReq.accessToken(false).sign(false).timeStamp(false);
        return mReq;
    }
}
