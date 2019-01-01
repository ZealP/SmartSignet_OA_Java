package com.smartsignet.smartsignet_oa_library_java.api;

import android.app.Application;
import android.text.TextUtils;

import com.jxtele.sealonline_library.net.http.EasyHttp;
import com.jxtele.sealonline_library.net.http.cache.model.CacheMode;
import com.smartsignet.smartsignet_oa_library_java.net.callback.ResultCallBack;
import com.smartsignet.smartsignet_oa_library_java.net.intercepter.SignIntercepter;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class SignetOnline {

    private static Application mApp;
    private static String mOpenId = "";
    private static String mSecretKey = "";
    private static String mBaseServiceAddr = "";

    /**
     * 初始化组件
     *
     * @param application Application对象
     * @param openId      平台唯一标识
     * @param secretKey   平台匹配密钥
     * @param serviceUrl  服务器地址
     */
    public static void initSealOnline(Application application, String openId, String secretKey, String serviceUrl) {
        mApp = application;
        if (!TextUtils.isEmpty(openId) && !TextUtils.isEmpty(secretKey) && !TextUtils.isEmpty(serviceUrl)) {
            mOpenId = openId;
            mSecretKey = secretKey;
            mBaseServiceAddr = serviceUrl;
        }
        initHttpReq(application, mBaseServiceAddr, mOpenId, mSecretKey);
    }

    /**
     * 获取印章列表
     *
     * @param version        请求版本号
     * @param resultCallback 返回结果回调
     */
    public static void getSignList(String version, ResultCallBack resultCallback) {
        SmartSignet.getInstance().getSignetList(mApp, mOpenId, version, resultCallback);
    }

    /**
     * 申请签章
     *
     * @param version        请求版本号
     * @param useCount       印章使用次数
     * @param surplusTimes   印章使用时间/秒
     * @param serialNo       印章设备序列号
     * @param applyReason    合同名称
     * @param resultCallback 返回结果回调
     */
    public static void applySignet(
            String version,
            int useCount,
            int surplusTimes,
            String serialNo,
            String applyReason,
            ResultCallBack resultCallback
    ) {
        SmartSignet.getInstance().applySignet(
                mApp,
                mOpenId,
                version,
                useCount,
                surplusTimes,
                serialNo,
                applyReason,
                resultCallback
        );
    }

    /**
     * 变更流程审批之拒绝
     *
     * @param version        请求版本号
     * @param applyId        申请流程编号
     * @param serialNo       印章设备序列号
     * @param resultCallback 返回结果回调
     */
    public static void refusedApprovalWorkflow(String version, String applyId, String serialNo, ResultCallBack resultCallback) {
        SmartSignet.getInstance().refusedApprovalWorkflow(mApp, mOpenId, version, applyId, serialNo, resultCallback);
    }

    /**
     * 变更流程审批之同意
     *
     * @param version        请求版本号
     * @param applyId        申请流程编号
     * @param serialNo       印章设备序列号
     * @param resultCallback 返回结果回调
     */
    public static void agreeApprovalWorkflow(String version, String applyId, String serialNo, ResultCallBack resultCallback) {
        SmartSignet.getInstance().agreeApprovalWorkflow(mApp, mOpenId, version, applyId, serialNo, resultCallback);
    }

    /**
     * 印章二维码扫描
     *
     * @param version        请求版本号
     * @param serialNum      印章序列号
     * @param applyId        申请流程编号
     * @param clientid       印章设备编码
     * @param resultCallback 返回结果回调
     */
    public static void signetQrCodeScan(String version, String serialNum, String applyId, String clientid, ResultCallBack resultCallback) {
        SmartSignet.getInstance().signetQrCodeScan(mApp, mOpenId, version, serialNum, applyId, clientid, resultCallback);
    }

    /**
     * 初始化网络请求框架
     *
     * @param openId    平台唯一标识
     * @param secretKey 平台匹配密钥
     */
    private static void initHttpReq(Application application, String baseServiceAddr, String openId, String secretKey) {
        EasyHttp.init(application);
        EasyHttp.getInstance()
                .setBaseUrl(baseServiceAddr)
                .debug("SmartSignet_OA_Java", true)
                .setReadTimeOut(20 * 1000)
                .setWriteTimeOut(40 * 1000)
                .setConnectTimeout(40 * 1000)
                .setRetryCount(2)
                .setRetryDelay(3000)
                .setRetryIncreaseDelay(2000)
                .setCacheMode(CacheMode.NO_CACHE)
                .setCacheTime(-1)
                .setCacheMaxSize(200 * 1024 * 1024)
                .setCacheVersion(1)
                .setOkconnectionPool(new ConnectionPool(10, 10, TimeUnit.MINUTES))
                .addInterceptor(new SignIntercepter(openId, secretKey));
    }
}
