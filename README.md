## SmartSignet_OA_Kotlin

政企(信产)研发中心 OA智能签章框架Java版

想使用Java版本的框架请移步 [OA智能签章框架Kotlin版](https://github.com/ZealP/SmartSignet_OA_Kotlin)

## 联系方式
使用存在问题可联系zealpeng@163.com

## 版本说明
### 最新版本
[![release](https://img.shields.io/badge/release-V1.0.1-orange.svg)](https://github.com/ZealP/SmartSignet_OA)
### 更新日志：
     v1.0.1：完成OA智能签章框架Kotlin版的研发工作，开放初版体验；

<!-- ### Demo下载
[![downloads](https://img.shields.io/badge/downloads-430k-blue.svg)](https://github.com/zhou-you/RxEasyHttp/blob/master/RxEasyHttp-Demo.apk?raw=true) -->

### 在相关build.gradle内做如下设置
```
allprojects {
        repositories {
            ...
            maven { url 'https://www.jitpack.io' }
        }
    }

dependencies {
    implementation 'com.github.ZealP:SmartSignet_OA:最新版本号'
}
```
### 全局配置
一般在 Aplication，或者基类中，只需要调用一次即可。
初始化需要Application#onCreate()中初始化，记得在manifest.xml中注册Application。
#### Application:
```
class MyApplication : Application() {
    companion object {
        lateinit var application: MyApplication
    }
    override fun onCreate() {
        super.onCreate()
        application = this
        /**
         * 初始化组件
         * @param application Application对象
         * @param openId  平台唯一标识
         * @param secretKey 平台匹配密钥
         * @param serviceUrl 服务器地址
         */
        SignetOnline.initSealOnline(this, "xxx", "xxx", "http://www.baidu.com")
    }
}
```

### 接口表
目前提供的接口表
```
    /**
     * 获取印章列表
     */
     getSignList

     /**
     * 申请签章
     */
     applySignet

     /**
     * 变更流程审批之同意
     */
     agreeApprovalWorkflow

     /**
     * 变更流程审批之拒绝
     */
     refusedApprovalWorkflow

     /**
     * 印章二维码扫描
     */
     signetQrCodeScan
```

### 接口实例
可按照如下实例进行调用
```
    /**
     * 获取印章列表
     */
    private fun testGetSignetList() {
        /**
         * 获取印章列表
         * @param version 请求版本号
         * @param ResultCallback 返回结果回调
         */
        SignetOnline?.getSignList("1.0.8", object : ResultCallBack() {
            /**
             * 返回请求成功
             * @param data 返回印章列表信息
             * @param msg 返回msg字段信息
             */
            override fun onResultSuccess(data: String?, msg: String?) {
                ToastUtil.showShort(MyApplication.application, msg ?: "")
                main_result_msg?.text = "[getSignList()]返回请求成功\nmsg = $msg\ndata = $data\n"
            }

            /**
             * 返回请求失败
             * @param code 返回错误状态code码
             * @param data 返回data字段信息
             * @param msg 返回msg字段信息
             */
            override fun onResultFail(code: String?, msg: String?, data: String?) {
                ToastUtil.showShort(MyApplication.application, msg ?: "")
                main_result_msg?.text = "[getSignList()]返回请求失败\ncode = $code\nmsg = $msg\ndata = $data\n"
            }

            /**
             * Http请求出错
             * @param e 返回相关请求失败信息
             */
            override fun onHttpReqErr(e: ApiException?) {
                ToastUtil.showShort(MyApplication.application, e?.message ?: "")
                main_result_msg?.text =
                        "[getSignList()]返回请求失败\ncode = ${e?.code}\nerrorMsg = $e?.message\nexception = \n${e?.printStackTrace()}\n"
            }
        })
    }
```

## 声明
此框架不得用来进行非本司或未被本司授权的商业化开发
