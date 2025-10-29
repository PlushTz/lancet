package com.plush.lancet.plugin.internal;

import org.gradle.api.Project;

import java.io.File;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class GlobalContext {
    private Project project;

    public GlobalContext(Project project) {
        this.project = project;
    }

    public File getLancetDir() {
        return new File(project.getBuildDir(), "lancet");
    }
}
