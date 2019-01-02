package com.smartsignet.smartsignet_oa_library_java.net.custom;


import com.jxtele.sealonline_library.net.http.model.ApiResult;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class CustomResult<T> extends ApiResult<T> {
    @Override
    public boolean isOk() {
        return getCode() == 200;
    }
}
