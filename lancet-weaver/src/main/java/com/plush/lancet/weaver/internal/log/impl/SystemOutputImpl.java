package com.plush.lancet.weaver.internal.log.impl;

import org.gradle.api.logging.LogLevel;

import java.io.PrintStream;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class SystemOutputImpl extends BaseLogger {
    @Override
    protected void write(LogLevel level, String prefix, String msg, Throwable t) {
        PrintStream ps = System.out;
        if (level == LogLevel.WARN || level == LogLevel.ERROR) {
            ps = System.err;
        }
        ps.println((String.format("%s [%-10s] %s", level.name(), prefix, msg)));
        if (t != null) {
            ps.println(level.name() + " " + stackToString(t));
        }
    }
}
