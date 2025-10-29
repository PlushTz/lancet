package com.plush.lancet.weaver.internal.log;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public interface Logger {
    void d(String tag,String msg);

    void i(String tag,String msg);

    void w(String tag,String msg);

    void w(String tag,String msg, Throwable t);

    void e(String tag,String msg);

    void e(String tag,String msg, Throwable t);
}
