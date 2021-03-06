package com.example.administrator.zhbj.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/5/6.
 */

public class PrefUtils {
    public static boolean getBoolean(Context context, String key, boolean defValue){
        SharedPreferences sp = context.getSharedPreferences("configs", Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }
    public static void setBoolean(Context context, String key, boolean value){
        SharedPreferences sp = context.getSharedPreferences("configs", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue){
        SharedPreferences sp = context.getSharedPreferences("configs", Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }
    public static void setString(Context context, String key, String value){
        SharedPreferences sp = context.getSharedPreferences("configs", Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }
}
