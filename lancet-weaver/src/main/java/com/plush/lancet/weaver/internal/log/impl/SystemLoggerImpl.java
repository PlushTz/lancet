package com.plush.lancet.weaver.internal.log.impl;

import org.gradle.api.logging.LogLevel;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class SystemLoggerImpl extends BaseLogger {
    private final Logger logger = Logging.getLogger("lancet");

    @Override
    protected synchronized void write(LogLevel level, String prefix, String msg, Throwable t) {
        if (t != null) {
            logger.log(level, String.format("[%-10s] %s", prefix, msg), t);
        } else {
            logger.log(level, String.format("[%-10s] %s", prefix, msg));
        }
    }
}
