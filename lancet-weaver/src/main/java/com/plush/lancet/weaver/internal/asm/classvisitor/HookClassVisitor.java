package com.plush.lancet.weaver.internal.asm.classvisitor;

import com.plush.lancet.weaver.internal.asm.LinkedClassVisitor;
import com.plush.lancet.weaver.internal.utils.TypeUtil;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Set;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class HookClassVisitor extends LinkedClassVisitor {
    private final Set<String> excludes;
    private boolean matched;

    public HookClassVisitor(Set<String> excludes) {
        this.excludes = excludes;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        getContext().name = name;
        getContext().superName = superName;
        if (excludes.contains(name)) {
            matched = true;
            this.cv = getContext().getTail(); // make delegate point to the tail, ignore middle transform
        }
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (matched) {
            return super.visitMethod(TypeUtil.resetAccessScope(access, Opcodes.ACC_PUBLIC), name, desc, signature, exceptions);
        } else {
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }
}
