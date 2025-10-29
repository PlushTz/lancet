package com.plush.lancet.plugin.internal.context;

import com.android.build.api.transform.QualifiedContent;

import java.io.IOException;

/**
 * Desc:
 * Unzip QualifiedContent and provide single class for inout ClassFetcher.
 * QualifiedContent may be one of {@link com.android.build.api.transform.JarInput} and {@link com.android.build.api.transform.DirectoryInput}.
 * So there are tow child of QualifiedContentProvider {@link JarContentProvider} and {@link DirectoryContentProvider}
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public interface QualifiedContentProvider {
    /**
     * start accept the classes
     *
     * @param content
     * @param processor
     * @throws IOException
     */
    void forEach(QualifiedContent content, ClassFetcher processor) throws IOException;
}
