package com.itdr.utils;

public class PathUTil {
    //获取路径工具类
    public static String getPath(String path){
        String s1 = path.replace(".","/");
        String[] sar = s1.split("/");
        return sar[1];
    }
}
