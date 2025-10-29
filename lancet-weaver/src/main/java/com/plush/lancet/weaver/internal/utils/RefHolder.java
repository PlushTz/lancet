package com.plush.lancet.weaver.internal.utils;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class RefHolder<T> {
    private T val;

    public RefHolder(T val) {
        this.val = val;
    }

    public void set(T val) {
        this.val = val;
    }

    public T get() {
        return val;
    }
}
