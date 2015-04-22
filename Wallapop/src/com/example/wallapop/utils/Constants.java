
package com.example.wallapop.utils;

public class Constants {
    /** 应用程序文件夹名称 **/
    public static String appdirname = "wallapop";

    /** 应用程序文件夹 **/
    public static String dir_appname = android.os.Environment.getExternalStorageDirectory()
            .getAbsolutePath() + "/" + appdirname;

    public static String dir_appcache = dir_appname + "/cache";
}
