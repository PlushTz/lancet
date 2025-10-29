package com.plush.lancet.plugin.internal.preprocess;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class ParseFailureException extends RuntimeException {
    public ParseFailureException() {
    }

    public ParseFailureException(String message) {
        super(message);
    }

    public ParseFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseFailureException(Throwable cause) {
        super(cause);
    }
}
