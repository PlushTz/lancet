package com.plush.lancet.plugin.internal.context;

import com.android.build.api.transform.QualifiedContent;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public abstract class TargetedQualifiedContentProvider implements QualifiedContentProvider {
    /**
     * Judge the QualifiedContent type
     * @param qualifiedContent {@link com.android.build.api.transform.JarInput} or {@link com.android.build.api.transform.DirectoryInput}
     * @return can this provider accept this QualifiedContent.
     */
    public abstract boolean accepted(QualifiedContent qualifiedContent);
}
