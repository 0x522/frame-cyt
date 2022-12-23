package com.cyt.tool;

import java.text.SimpleDateFormat;
import java.util.function.Supplier;

public class SimpleDateFormatUtils {

    //使用threadLocal的方式线程安全的格式化时间
    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static SimpleDateFormat getTime() {
        SimpleDateFormat simpleDateFormat = THREAD_LOCAL.get();
        if (simpleDateFormat == null) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return simpleDateFormat;
    }

}