package com.smartsignet.smartsignet_oa_library_java.contact;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class ApiContact {

    /**
     * api通过该接口请求信息
     */
    public static final String BASE_API = "/eh-web-api/gateway";

    public static class METHOD {

        /**
         * 申请签章流程
         */
        public static final String METHOD_SEAL_APPLY = "com.shuige.flow.ymApply";
        /**
         * 签章列表
         */
        public static final String METHOD_SIGNET_LIST = "com.shuige.signet.ymSignetList";
        /**
         * 审批印章同意
         */
        public static final String METHOD_APPROVAL_WORKFLOW_AGREE = "com.shuige.flow.ymApprove";
        /**
         * 审批印章拒绝
         */
        public static final String METHOD_APPROVAL_WORKFLOW_REFUSED = "com.shuige.flow.refusedApply";
        /**
         * 印章二维码扫描接口
         */
        public static final String METHOD_QRCODE_SCAN = "com.shuige.signet.ymScanning";

    }
}
