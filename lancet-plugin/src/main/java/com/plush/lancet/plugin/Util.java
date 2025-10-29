package com.plush.lancet.plugin;

import java.io.File;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/23
 * Email: lijt@eetrust.com
 */
public class Util {
    public static File toSystemDependentFile(File parent, String relativePath) {
        return new File(parent, relativePath.replace('/', File.separatorChar));
    }

    public static File toSystemDependentHookFile(File relativeRoot, String relativePath) {
        int index = relativePath.lastIndexOf('.');
        return toSystemDependentFile(relativeRoot, relativePath.substring(0, index) + ClassTransform.AID_INNER_CLASS_NAME + relativePath.substring(index));
    }
}
