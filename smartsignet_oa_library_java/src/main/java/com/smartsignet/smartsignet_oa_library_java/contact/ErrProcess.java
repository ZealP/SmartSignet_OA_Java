package com.smartsignet.smartsignet_oa_library_java.contact;

import android.content.Context;
import android.widget.Toast;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class ErrProcess {

    /**
     * 请求成功
     */
    private static final String REQ_SUC = "0";

    /**
     * 结果反馈
     */
    public static Boolean parseRequestResult(Context context, String code, String msg) {
        switch (code) {
            case REQ_SUC:
                return true;
            default:
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}
