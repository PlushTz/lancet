package com.plush.lancet.weaver.internal.log.impl;

import org.gradle.api.logging.LogLevel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class FileLoggerImpl extends BaseLogger {
    public static FileLoggerImpl of(String fileName) throws FileNotFoundException {
        PrintWriter pr = new PrintWriter(new FileOutputStream(fileName), true);
        return new FileLoggerImpl(pr);
    }

    private PrintWriter pr;

    private FileLoggerImpl(PrintWriter pr) {
        this.pr = pr;
    }

    @Override
    protected void write(LogLevel level, String prefix, String msg, Throwable t) {
        pr.println(String.format("%s [%-10s] %s", level.name(), prefix, msg));
        if (t != null) {
            t.printStackTrace(pr);
        }
    }
}
