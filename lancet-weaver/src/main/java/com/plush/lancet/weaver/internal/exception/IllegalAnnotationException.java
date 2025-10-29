package com.plush.lancet.weaver.internal.exception;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class IllegalAnnotationException extends IllegalArgumentException {
    public IllegalAnnotationException() {
    }

    public IllegalAnnotationException(String s) {
        super(s);
    }

    public IllegalAnnotationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAnnotationException(Throwable cause) {
        super(cause);
    }
}
