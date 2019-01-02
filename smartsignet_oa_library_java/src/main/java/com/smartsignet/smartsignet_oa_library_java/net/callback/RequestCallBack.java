package com.smartsignet.smartsignet_oa_library_java.net.callback;

import com.jxtele.sealonline_library.net.http.exception.ApiException;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public interface RequestCallBack {

    void onStart();

    void onSuccess(String data, String msg);

    void onFail(String code, String msg, String data);

    void onHttpErr(ApiException e);
}
