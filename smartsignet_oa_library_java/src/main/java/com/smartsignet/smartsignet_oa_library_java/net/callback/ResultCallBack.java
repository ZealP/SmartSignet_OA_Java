package com.smartsignet.smartsignet_oa_library_java.net.callback;


import com.jxtele.sealonline_library.net.http.exception.ApiException;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public abstract class ResultCallBack implements RequestCallBack {

    @Override
    public void onStart() {
    }

    @Override
    public void onHttpErr(ApiException e) {
        onHttpReqErr(e);
    }

    @Override
    public void onFail(String code, String msg, String data) {
        onResultFail(code, msg, data);
    }

    @Override
    public void onSuccess(String data, String msg) {
        onResultSuccess(data, msg);
    }

    public abstract void onResultSuccess(String data, String msg);

    public abstract void onResultFail(String code, String msg, String data);

    public abstract void onHttpReqErr(ApiException e);
}
