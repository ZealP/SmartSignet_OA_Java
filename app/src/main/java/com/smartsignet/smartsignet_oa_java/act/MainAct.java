package com.smartsignet.smartsignet_oa_java.act;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.smartsignet.smartsignet_oa_java.R;
import com.smartsignet.smartsignet_oa_library_java.api.SignetOnline;
import com.smartsignet.smartsignet_oa_library_java.net.callback.ResultCallBack;
import com.jxtele.sealonline_library.net.http.exception.ApiException;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/30
 * Email: zealpeng@163.com
 * Description:
 */
public class MainAct extends Activity {

    TextView main_result_msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_main);
        main_result_msg = findViewById(R.id.main_result_msg);

//        testGetSignetList();
        testSignetQrCodeScan();
    }

    /**
     * 获取印章列表
     */
    private void testGetSignetList() {
        /**
         * 获取印章列表
         * @param version 请求版本号
         * @param ResultCallback 返回结果回调
         */
        SignetOnline.getSignList("1.0.8", new ResultCallBack() {
            /**
             * 返回请求成功
             * @param data 返回印章列表信息
             * @param msg 返回msg字段信息
             */
            @Override
            public void onResultSuccess(String data, String msg) {
                Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求成功\nmsg = " + msg + "\ndata = " + data + "\n");
            }

            /**
             * 返回请求失败
             * @param code 返回错误状态code码
             * @param data 返回data字段信息
             * @param msg 返回msg字段信息
             */
            @Override
            public void onResultFail(String code, String msg, String data) {
                Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + code + "\nmsg = " + msg + "\ndata = " + data + "\n");
            }

            /**
             * Http请求出错
             * @param e 返回相关请求失败信息
             */
            @Override
            public void onHttpReqErr(ApiException e) {
                Toast.makeText(MainAct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + e.getCode() + "\nerrorMsg = " + e.getMessage() + "\nexception = " + e.fillInStackTrace().toString() + "\n");
            }
        });
    }

    /**
     * 申请签章
     */
    private void testApplySignet() {
        /**
         * 申请签章
         * @param version 请求版本号
         * @param useCount 印章使用次数
         * @param surplusTimes 印章使用时间/秒
         * @param serialNo 印章设备序列号
         * @param applyReason 合同名称
         * @param ResultCallback 返回结果回调
         */
        SignetOnline.applySignet("1.0.8", 1, 5 * 60, "9ffq99f89q99vq99f", "企业员工劳务合同", new ResultCallBack() {
            /**
             * 返回请求成功
             * @param data 返回申请流程编号
             * @param msg 返回msg字段信息
             */
            @Override
            public void onResultSuccess(String data, String msg) {
                Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求成功\nmsg = " + msg + "\ndata = " + data + "\n");
            }

            /**
             * 返回请求失败
             * @param code 返回错误状态code码
             * @param data 返回data字段信息
             * @param msg 返回msg字段信息
             */
            @Override
            public void onResultFail(String code, String msg, String data) {
                Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + code + "\nmsg = " + msg + "\ndata = " + data + "\n");
            }

            /**
             * Http请求出错
             * @param e 返回相关请求失败信息
             */
            @Override
            public void onHttpReqErr(ApiException e) {
                Toast.makeText(MainAct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + e.getCode() + "\nerrorMsg = " + e.getMessage() + "\nexception = " + e.fillInStackTrace().toString() + "\n");
            }
        });
    }

    /**
     * 变更流程审批之同意
     */
    private void testAgreeApprovalWorkflow() {
        /**
         * 变更流程审批之同意
         * @param version 请求版本号
         * @param applyId 申请流程编号
         * @param serialNo 印章设备序列号
         * @param ResultCallback 返回结果回调
         */
        SignetOnline.agreeApprovalWorkflow("1.0.8", "9ffq99f89q99vq99f", "9ffq99f89q99vq99f", new ResultCallBack() {
            /**
             * 返回请求成功
             * @param data 返回null
             * @param msg 返回msg字段信息
             */
            @Override
            public void onResultSuccess(String data, String msg) {
                Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求成功\nmsg = " + msg + "\ndata = " + data + "\n");
            }

            /**
             * 返回请求失败
             * @param code 返回错误状态code码
             * @param data 返回data字段信息
             * @param msg 返回msg字段信息
             */
            @Override
            public void onResultFail(String code, String msg, String data) {
                Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + code + "\nmsg = " + msg + "\ndata = " + data + "\n");
            }

            /**
             * Http请求出错
             * @param e 返回相关请求失败信息
             */
            @Override
            public void onHttpReqErr(ApiException e) {
                Toast.makeText(MainAct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + e.getCode() + "\nerrorMsg = " + e.getMessage() + "\nexception = " + e.fillInStackTrace().toString() + "\n");
            }
        });
    }

    /**
     * 变更流程审批之拒绝
     */
    private void testRefusedApprovalWorkflow() {
        /**
         * 变更流程审批之拒绝
         * @param version 请求版本号
         * @param applyId 申请流程编号
         * @param serialNo 印章设备序列号
         * @param ResultCallback 返回结果回调
         */
        SignetOnline.refusedApprovalWorkflow(
                "1.0.8",
                "9ffq99f89q99vq99f",
                "9ffq99f89q99vq99f", new ResultCallBack() {
                    /**
                     * 返回请求成功
                     * @param data 返回null
                     * @param msg 返回msg字段信息
                     */
                    @Override
                    public void onResultSuccess(String data, String msg) {
                        Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                        main_result_msg.setText("[getSignList()]返回请求成功\nmsg = " + msg + "\ndata = " + data + "\n");
                    }

                    /**
                     * 返回请求失败
                     * @param code 返回错误状态code码
                     * @param data 返回data字段信息
                     * @param msg 返回msg字段信息
                     */
                    @Override
                    public void onResultFail(String code, String msg, String data) {
                        Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                        main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + code + "\nmsg = " + msg + "\ndata = " + data + "\n");
                    }

                    /**
                     * Http请求出错
                     * @param e 返回相关请求失败信息
                     */
                    @Override
                    public void onHttpReqErr(ApiException e) {
                        Toast.makeText(MainAct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + e.getCode() + "\nerrorMsg = " + e.getMessage() + "\nexception = " + e.fillInStackTrace().toString() + "\n");
                    }
                });
    }

    /**
     * 印章二维码扫描
     */
    private void testSignetQrCodeScan() {
        /**
         * 印章二维码扫描
         * @param version 请求版本号
         * @param serialNum 印章序列号
         * @param applyId 申请流程编号
         * @param clientid 印章设备编码
         * @param ResultCallback 返回结果回调
         */
        SignetOnline.signetQrCodeScan(
                "1.0.8",
                "9ffq99f89q99vq99f",
                "9ffq99f89q99vq99f",
                "9ffq99f89q99vq99f", new ResultCallBack() {
                    /**
                     * 返回请求成功
                     * @param data 返回印章序列号
                     * @param msg 返回msg字段信息
                     */
                    @Override
                    public void onResultSuccess(String data, String msg) {
                        Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                        main_result_msg.setText("[getSignList()]返回请求成功\nmsg = " + msg + "\ndata = " + data + "\n");
                    }

                    /**
                     * 返回请求失败
                     * @param code 返回错误状态code码
                     * @param data 返回data字段信息
                     * @param msg 返回msg字段信息
                     */
                    @Override
                    public void onResultFail(String code, String msg, String data) {
                        Toast.makeText(MainAct.this, msg, Toast.LENGTH_SHORT).show();
                        main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + code + "\nmsg = " + msg + "\ndata = " + data + "\n");
                    }

                    /**
                     * Http请求出错
                     * @param e 返回相关请求失败信息
                     */
                    @Override
                    public void onHttpReqErr(ApiException e) {
                        Toast.makeText(MainAct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        main_result_msg.setText("[getSignList()]返回请求失败\ncode = " + e.getCode() + "\nerrorMsg = " + e.getMessage() + "\nexception = " + e.fillInStackTrace().toString() + "\n");
                    }
                });
    }
}
