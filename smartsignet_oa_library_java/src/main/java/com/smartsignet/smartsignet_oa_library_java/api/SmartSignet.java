package com.smartsignet.smartsignet_oa_library_java.api;

import android.app.Application;
import com.smartsignet.smartsignet_oa_library_java.contact.ApiContact;
import com.smartsignet.smartsignet_oa_library_java.net.base.NetRequest;
import com.smartsignet.smartsignet_oa_library_java.net.callback.ResultCallBack;
import com.smartsignet.smartsignet_oa_library_java.net.callback.SkCallBack;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class SmartSignet {

    public static SmartSignet smartSignet;

    private SmartSignet() {
    }

    public static SmartSignet getInstance() {
        if (smartSignet == null) {
            synchronized (SmartSignet.class) {
                if (smartSignet == null)
                    smartSignet = new SmartSignet();
            }
        }
        return smartSignet;
    }

    /**
     * 申请签章
     */
    public void applySignet(
            Application application,
            String openId,
            String version,
            int useCount,
            int surplusTimes,
            String serialNo,
            String applyReason,
            ResultCallBack resultCallback
    ) {
        NetRequest
                .getInstance()
                .doGetReq(ApiContact.BASE_API, true)
                .params("method", ApiContact.METHOD.METHOD_SEAL_APPLY)
                .params("v", version)
                .params("openid", openId)
                .params("useCount", useCount + "")
                .params("surplusTimes", surplusTimes + "")
                .params("serialNo", serialNo)
                .params("applyReason", applyReason)
                .execute(new SkCallBack(application, resultCallback) {
                });
    }

    /**
     * 变更流程审批之拒绝
     */
    public void refusedApprovalWorkflow(
            Application application,
            String openId,
            String version,
            String applyId,
            String serialNo,
            ResultCallBack resultCallback
    ) {
        NetRequest
                .getInstance()
                .doGetReq(ApiContact.BASE_API, true)
                .params("method", ApiContact.METHOD.METHOD_APPROVAL_WORKFLOW_REFUSED)
                .params("v", version)
                .params("openid", openId)
                .params("applyId", applyId)
                .params("serialNo", serialNo)
                .execute(new SkCallBack(application, resultCallback) {
                });
    }

    /**
     * 变更流程审批之同意
     */
    public void agreeApprovalWorkflow(
            Application application,
            String openId,
            String version,
            String applyId,
            String serialNo,
            ResultCallBack resultCallback
    ) {
        NetRequest
                .getInstance()
                .doGetReq(ApiContact.BASE_API, true)
                .params("method", ApiContact.METHOD.METHOD_APPROVAL_WORKFLOW_AGREE)
                .params("v", version)
                .params("openid", openId)
                .params("applyId", applyId)
                .params("serialNo", serialNo)
                .execute(new SkCallBack(application, resultCallback) {
                });
    }

    /**
     * 印章二维码扫描接口
     */
    public void signetQrCodeScan(
            Application application,
            String openId,
            String version,
            String serialNum,
            String applyId,
            String clientid,
            ResultCallBack resultCallback
    ) {
        NetRequest
                .getInstance()
                .doGetReq(ApiContact.BASE_API, true)
                .params("method", ApiContact.METHOD.METHOD_QRCODE_SCAN)
                .params("v", version)
                .params("openid", openId)
                .params("applyId", applyId)
                .params("serialNum", serialNum)
                .params("clientid", clientid)
                .execute(new SkCallBack(application, resultCallback) {
                });
    }

    /**
     * 印章信息列表
     */
    public void getSignetList(
            Application application,
            String openId,
            String version,
            ResultCallBack resultCallback
    ) {
        NetRequest
                .getInstance()
                .doGetReq(ApiContact.BASE_API, true)
                .params("method", ApiContact.METHOD.METHOD_SIGNET_LIST)
                .params("v", version)
                .params("openid", openId)
                .execute(new SkCallBack<String>(application, resultCallback) {
                });
    }
}
