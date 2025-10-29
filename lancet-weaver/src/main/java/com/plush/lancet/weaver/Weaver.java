package com.plush.lancet.weaver;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public interface Weaver {
    /**
     * Transform input class with specified rules.
     * Input one class may return two classes, because weaver may create multiple inner classes.
     * this method will be invoke in multi-threaded and multi-process
     *
     * @param input the bytecode of the class want to transform.
     * @param relativePath the file path of the class, end with .class, the new classes will output into the same path.
     * @return the bytecode of transformed classes.
     */
    ClassData[] weave(byte[] input, String relativePath);
}
