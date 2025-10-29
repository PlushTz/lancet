package com.plush.lancet.weaver.internal.exception;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class LoadClassException extends RuntimeException {
    public LoadClassException(String message, Throwable cause) {
        super(message, cause);
    }
}
