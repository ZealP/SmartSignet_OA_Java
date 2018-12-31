package com.smartsignet.smartsignet_oa_library_java.net.callback;

import android.content.Context;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.jxtele.sealonline_library.net.http.callback.CallBack;
import com.jxtele.sealonline_library.net.http.exception.ApiException;
import com.smartsignet.smartsignet_oa_library_java.contact.ErrProcess;
import com.smartsignet.smartsignet_oa_library_java.entity.BaseMsg;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public abstract class SkCallBack<T> extends CallBack<T> {

    private Context mContext;
    private ResultCallBack resultCallback;

    public SkCallBack(Context context, ResultCallBack callback) {
        if (mContext != null) {
            mContext = context;
            resultCallback = callback;
        }
    }

    @Override
    public void onSuccess(T t) {
        try {
            BaseMsg mMsg;

            if (t instanceof String)
                mMsg = JSON.parseObject((String) t, BaseMsg.class);
            else
                return;

            if (mMsg != null) {

                if (mMsg.code.equals("0") || mMsg.msg != null)
                    resultMsg(mMsg, !ErrProcess.parseRequestResult(mContext, mMsg.code, mMsg.msg));
                else
                    resultMsg(mMsg, true);

            } else {
                Toast.makeText(mContext, "数据解析失败，请稍后再试或联系管理员", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(mContext, "处理出错", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(ApiException e) {
        try {
            ErrProcess.parseRequestResult(mContext, e.getCode() + "", e.getMessage());
            if (resultCallback != null)
                resultCallback.onHttpReqErr(e);
        } catch (Exception e1) {
            Toast.makeText(mContext, "处理出错", Toast.LENGTH_SHORT).show();
        }
    }

    private void resultMsg(BaseMsg msg, Boolean isResultErr) {
        if (isResultErr == false) {
            if (resultCallback != null)
                resultCallback.onResultSuccess(msg.data, msg.msg);
        } else {
            if (resultCallback != null)
                resultCallback.onResultFail(msg.code, msg.msg, msg.data);
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onStart() {
        if (resultCallback != null)
            resultCallback.onStart();
    }
}
