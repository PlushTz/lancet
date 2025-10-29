package com.plush.lancet.plugin.internal.context;

import com.android.build.api.transform.JarInput;
import com.android.build.api.transform.Status;
import com.plush.lancet.plugin.internal.TransformContext;

import org.gradle.internal.impldep.com.google.common.base.Charsets;
import org.gradle.internal.impldep.com.google.common.hash.Hashing;

import java.io.File;
import java.util.Set;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class StatusOverrideJarInput implements JarInput {
    private JarInput jarInput;
    private File jar;
    private Status status;


    public StatusOverrideJarInput(TransformContext context, JarInput jarInput, Status status) {
        this.jarInput = jarInput;
        this.jar = context.getRelativeFile(jarInput);
        this.status = status;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String getName() {
        return Hashing.sha1().hashString(jar.getPath() + status, Charsets.UTF_16LE).toString();
    }

    @Override
    public File getFile() {
        return jar;
    }

    @Override
    public Set<ContentType> getContentTypes() {
        return jarInput.getContentTypes();
    }

    @Override
    public Set<? super Scope> getScopes() {
        return jarInput.getScopes();
    }
}
