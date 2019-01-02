package com.jxtele.sealonline_library.net.http.subsciber;

import android.content.Context;

import com.jxtele.sealonline_library.net.http.callback.CallBack;
import com.jxtele.sealonline_library.net.http.callback.ProgressDialogCallBack;
import com.jxtele.sealonline_library.net.http.exception.ApiException;

import io.reactivex.annotations.NonNull;


/**
 * <p>描述：带有callBack的回调</p>
 * 主要作用是不需要用户订阅，只要实现callback回调<br>
 * 作者： zhouyou<br>
 * 日期： 2016/12/28 17:10<br>
 * 版本： v2.0<br>
 */
public class CallBackSubsciber<T> extends BaseSubscriber<T> {
    public CallBack<T> mCallBack;
    

    public CallBackSubsciber(Context context, CallBack<T> callBack) {
        super(context);
        mCallBack = callBack;
        if (callBack instanceof ProgressDialogCallBack) {
            ((ProgressDialogCallBack) callBack).subscription(this);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (mCallBack != null) {
            mCallBack.onStart();
        }
    }
    
    @Override
    public void onError(ApiException e) {
        if (mCallBack != null) {
            mCallBack.onError(e);
        }
    }

    @Override
    public void onNext(@NonNull T t) {
        super.onNext(t);
        if (mCallBack != null) {
            mCallBack.onSuccess(t);
        }
    }

    @Override
    public void onComplete() {
        super.onComplete();
        if (mCallBack != null) {
            mCallBack.onCompleted();
        }
    }
}
