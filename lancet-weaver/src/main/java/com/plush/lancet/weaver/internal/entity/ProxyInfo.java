package com.plush.lancet.weaver.internal.entity;

import com.plush.lancet.weaver.internal.utils.AsmUtil;
import com.google.common.base.Strings;

import org.objectweb.asm.tree.MethodNode;

import java.util.regex.Pattern;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class ProxyInfo {
    public String regex;
    public String targetClass;
    public String targetMethod;
    public String targetDesc;
    public String sourceClass;
    public MethodNode sourceMethod;

    public Pattern pattern;

    private ThreadLocal<MethodNode> local = new ThreadLocal<MethodNode>() {
        @Override
        synchronized protected MethodNode initialValue() {
            return AsmUtil.clone(sourceMethod);
        }
    };

    public ProxyInfo(String regex, String targetClass, String targetMethod, String targetDesc, String sourceClass, MethodNode sourceMethod) {
        this.regex = regex;
        this.targetClass = targetClass;
        this.targetMethod = targetMethod;
        this.targetDesc = targetDesc;
        this.sourceClass = sourceClass;
        this.sourceMethod = sourceMethod;

        if (!Strings.isNullOrEmpty(regex)) {
            this.pattern = Pattern.compile(regex);
        }
    }

    public MethodNode threadLocalNode() {
        return local.get();
    }

    public boolean match(String className) {
        return pattern == null || pattern.matcher(className).matches();
    }


    @Override
    public String toString() {
        return "ProxyInfo{" + "  regex=" + regex + ", targetClass='" + targetClass + '\'' + ", targetMethod='" + targetMethod + '\'' + ", targetDesc='" + targetDesc + '\'' + ", sourceMethod.name=" + sourceMethod.name + ", sourceMethod.desc=" + sourceMethod.desc + ", sourceMethod.signature=" + sourceMethod.signature + ", sourceMethod.access=" + sourceMethod.access + ", sourceMethod.codeSize=" + sourceMethod.instructions.size() + '}';
    }
}
