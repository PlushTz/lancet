package com.plush.lancet.weaver.internal.parser;

import com.plush.lancet.weaver.internal.meta.HookInfoLocator;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public abstract class AnnotationMeta {
    public AnnotationMeta(String desc) {
        this.desc = desc;
    }

    public String desc;

    public abstract void accept(HookInfoLocator locator);
}
