package com.smartsignet.smartsignet_oa_java.app;

import android.app.Application;

import com.smartsignet.smartsignet_oa_library_java.api.SignetOnline;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/30
 * Email: zealpeng@163.com
 * Description:
 */
public class App extends Application {

    public static App application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        /**
         * 初始化组件
         * @param application Application对象
         * @param openId  平台唯一标识
         * @param secretKey 平台匹配密钥
         * @param serviceUrl 服务器地址
         */
//        SignetOnline.initSealOnline(this, "xxx", "xxx", "http://www.baidu.com");
        SignetOnline.initSealOnline(this, "a7d4f11d9cb247b283a77b586a1144ca", "af6b272ee61449cf89aadb25657e9ba0", "http://xxapi.pre.xyvip.com");
    }
}
