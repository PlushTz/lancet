package com.plush.lancet.plugin.internal.context;

import com.android.build.api.transform.DirectoryInput;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Status;
import com.plush.lancet.weaver.internal.log.Log;

import org.gradle.internal.impldep.com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class DirectoryContentProvider extends TargetedQualifiedContentProvider {
    private final boolean incremental;

    public DirectoryContentProvider(boolean incremental) {
        this.incremental = incremental;
    }

    @Override
    public void forEach(QualifiedContent content, ClassFetcher processor) throws IOException {
        if (processor.onStart(content)) {
            File root = content.getFile();
            URI base = root.toURI();
            if (!incremental) {
                /**
                 * if this compile is full compilation. we traverse all classes as newly added classes
                 */
                for (File f : Files.fileTraverser().depthFirstPreOrder(root)) {
                    if (f.isFile() && f.getName().endsWith(".class")) {
                        byte[] data = Files.toByteArray(f);
                        String relativePath = base.relativize(f.toURI()).toString();
                        processor.onClassFetch(content, Status.ADDED, relativePath, data);
                    }
                }
            } else {
                /**
                 * if this compile is incremental compilation. we traverse all changed classes.
                 */
                for (Map.Entry<File, Status> entry : ((DirectoryInput) content).getChangedFiles().entrySet()) {
                    Log.d(entry.getKey() + " " + entry.getValue());
                    File f = entry.getKey();
                    if (f.isFile() && f.getName().endsWith(".class")) {
                        byte[] data = Files.toByteArray(f);
                        String relativePath = base.relativize(f.toURI()).toString();
                        processor.onClassFetch(content, entry.getValue(), relativePath, data);
                    }
                }
            }
        }
        processor.onComplete(content);
    }

    @Override
    public boolean accepted(QualifiedContent qualifiedContent) {
        return qualifiedContent instanceof DirectoryInput;
    }
}
