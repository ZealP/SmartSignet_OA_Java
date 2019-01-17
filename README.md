# OA智能签章框架Java版

政企(信产)研发中心 OA智能签章框架Java版

## 联系方式

使用存在问题可联系研发中心或zealpeng@163.com

## 版本说明
### 最新版本
<!-- [![release](https://img.shields.io/badge/beta-v1.0.1-orange.svg)](https://github.com/ZealP/SmartSignet_OA_Java)-->

[![](https://www.jitpack.io/v/ZealP/SmartSignet_OA_Java.svg)](https://www.jitpack.io/#ZealP/SmartSignet_OA_Java)

<!-- ### Demo下载
[![downloads](https://img.shields.io/badge/downloads-430k-blue.svg)](https://github.com/zhou-you/RxEasyHttp/blob/master/RxEasyHttp-Demo.apk?raw=true) -->

### 添加Gradle依赖

1. 先在项目根目录的 build.gradle 的 repositories 添加:

```gradle
allprojects {
        repositories {
            ...
            maven { url 'https://www.jitpack.io' }
        }
    }
```

2. 然后在dependencies添加:

```gradle
dependencies {
    implementation 'com.github.ZealP:SmartSignet_OA_Java:最新版本号'
}
```
### 全局配置

一般在 Aplication，或者基类中，只需要调用一次即可。
初始化需要Application#onCreate()中初始化，记得在manifest.xml中注册Application。

Application:

```java
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
         * @param serviceUrl 平台服务器地址 例如http://www.baidu.com
         */
        SignetOnline.initSealOnline(this, "填写openid", "填写secretKey", "填写serviceUrl");
    }
}
```

## 接口表

目前提供的接口表
其中通用字段有两个(version和resultCallback)
version指该请求当前的请求版本号

```java
    /**
     * 获取印章列
     *
     * 最新的version(请求版本号): 1.0.8
     *
     * @param version        请求版本号
     * @param resultCallback 返回结果回调
     */
     getSignList(version, resultCallback)

     /**
      * 申请签章
      *
      * 最新的version(请求版本号): 1.0.8
      *
      * @param version        请求版本号
      * @param useCount       印章使用次数
      * @param surplusTimes   印章使用时间/秒
      * @param serialNo       印章设备序列号
      * @param applyReason    合同名称
      * @param resultCallback 返回结果回调
      */
     applySignet(version, useCount, surplusTimes, serialNo, applyReason, resultCallback)

     /**
      * 变更流程审批之拒绝
      *
      * 最新的version(请求版本号): 1.0.8
      *
      * @param version        请求版本号
      * @param applyId        申请流程编号
      * @param serialNo       印章设备序列号
      * @param resultCallback 返回结果回调
      */
     agreeApprovalWorkflow(version, applyId, serialNo, resultCallback)

     /**
      * 变更流程审批之同意
      *
      * 最新的version(请求版本号): 1.0.8
      *
      * @param version        请求版本号
      * @param applyId        申请流程编号
      * @param serialNo       印章设备序列号
      * @param resultCallback 返回结果回调
      */
     refusedApprovalWorkflow(version, applyId, serialNo, resultCallback)

     /**
      * 印章二维码扫描
      *
      * 最新的version(请求版本号): 1.0.8
      *
      * @param version        请求版本号
      * @param serialNum      印章序列号
      * @param applyId        申请流程编号
      * @param clientid       印章设备编码
      * @param resultCallback 返回结果回调
      */
     signetQrCodeScan(version, serialNum, applyId, clientid, resultCallback)
```

## 接口实例

接口可按照如下实例进行调用:

```java
        /**
         * 示例:调用接口获取印章列表
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
                   // TODO
                }
    
                /**
                 * 返回请求失败
                 * @param code 返回错误状态code码
                 * @param data 返回data字段信息
                 * @param msg 返回msg字段信息
                 */
                @Override
                public void onResultFail(String code, String msg, String data) {
                    // TODO
                }
    
                /**
                 * Http请求出错
                 * @param e 返回相关请求失败信息
                 */
                @Override
                public void onHttpReqErr(ApiException e) {
                    // TODO
                }
            });
        }
```

>注意：
version(最新请求版本号) 字段值在接口表内有注明。因为请求信息是异步处理的，ResultCallBack是用来回调处理结果的，它有多个回调方法可供调用。

ResultCallBack所有回调方法如下:

```java
            /**
             * 请求成功回调的信息
             * @param data 返回平台信息字段（内容请自行解析，可能是json字符串或其他内容）
             * @param msg 返回msg字段信息(状态信息等其他内容)
             */
            @Override
            public void onResultSuccess(String data, String msg) {
               // TODO
            }
            
            /**
             * 请求失败回调的信息
             * @param code 返回失败状态code码
             * @param data 返回平台信息字段（内容请自行解析，可能是json字符串或其他内容）
             * @param msg 返回msg字段信息(失败原因等其他内容)
             */
            @Override
            public void onResultFail(String code, String msg, String data) {
               // TODO
            }
            
            /**
             * Http请求出错
             * @param e 返回该HTTP请求失败的异常信息实体(内部包含请求错误code码、异常信息message等内容)
             */
            @Override
            public void onHttpReqErr(ApiException e) {
               // TODO
            }
            
            /**
             * 该回调是隐藏回调，如需在请求开始时回调可用该接口
             * 例如需请求接口时添加加载框时可在此实现
             */
            @Override
            public void onStart() {
               // TODO
            }
```

## 声明

此框架不得用来进行非本司或未被本司授权的商业化开发

想使用Kotlin版本的框架请移步 [OA智能签章框架Kotlin版(已停止维护)](https://github.com/ZealP/SmartSignet_OA_Kotlin)

