package com.smartsignet.smartsignet_oa_library_java.net.custom;

import com.jxtele.sealonline_library.net.http.callback.CallBack;
import com.jxtele.sealonline_library.net.http.callback.CallBackProxy;
import com.jxtele.sealonline_library.net.http.callback.CallClazzProxy;
import com.jxtele.sealonline_library.net.http.request.GetRequest;

import java.lang.reflect.Type;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class CustomGet extends GetRequest {

    public CustomGet(String url) {
        super(url);
    }

    @Override
    public <T> Disposable execute(CallBack<T> callBack) {
        return super.execute(new CallBackProxy<CustomResult<T>, T>(callBack) {
        });
    }

    @Override
    public <T> Observable<T> execute(Type type) {
        return super.execute(new CallClazzProxy<CustomResult<T>, T>(type) {
        });
    }

    @Override
    public <T> Observable<T> execute(Class<T> clazz) {
        return super.execute(new CallClazzProxy<CustomResult<T>, T>(clazz) {
        });
    }
}
