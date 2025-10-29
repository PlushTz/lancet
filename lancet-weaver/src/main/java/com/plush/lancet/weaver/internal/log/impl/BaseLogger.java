package com.plush.lancet.weaver.internal.log.impl;

import com.plush.lancet.weaver.internal.log.Logger;

import org.gradle.api.logging.LogLevel;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public abstract class BaseLogger implements Logger {
    @Override
    public void d(String tag, String msg) {
        write(LogLevel.DEBUG, tag, msg, null);
    }

    @Override
    public void i(String tag, String msg) {
        write(LogLevel.INFO, tag, msg, null);
    }

    @Override
    public void w(String tag, String msg) {
        w(tag, msg, null);
    }

    @Override
    public void w(String tag, String msg, Throwable t) {
        write(LogLevel.WARN, tag, msg, t);
    }

    @Override
    public void e(String tag, String msg) {
        e(tag, msg, null);
    }

    @Override
    public void e(String tag, String msg, Throwable t) {
        write(LogLevel.ERROR, tag, msg, t);
    }

    protected abstract void write(LogLevel level, String prefix, String msg, Throwable t);

    static String stackToString(Throwable t) {
        StringWriter sw = new StringWriter(128);
        PrintWriter ps = new PrintWriter(sw);
        t.printStackTrace(ps);
        ps.flush();
        return sw.toString();
    }
}
