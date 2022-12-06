package org.bsm.bsm.util;

public class SessionAttributeUtil {
    static String userInfo = "userInfo"; //存储用户信息
    static String SearchType ="type"; //存储当前搜索的类型选项
    static String SearchString = "str"; //存储当前搜索的字符串

    static String manager="manager";

    public static String getSearchString() {
        return SearchString;
    }

    public static String getUserInfo() {
        return userInfo;
    }

    public static String getSearchType() {
        return SearchType;
    }

    public static String getManager() {
        return manager;
    }
}
