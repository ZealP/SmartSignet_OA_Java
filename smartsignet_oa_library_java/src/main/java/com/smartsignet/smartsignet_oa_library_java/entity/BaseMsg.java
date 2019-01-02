package com.smartsignet.smartsignet_oa_library_java.entity;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/31
 * Email: zealpeng@163.com
 * Description:
 */
public class BaseMsg {

    public String code;
    public String msg;
    public String data;

    @Override
    public String toString() {
        return "BaseMsg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
