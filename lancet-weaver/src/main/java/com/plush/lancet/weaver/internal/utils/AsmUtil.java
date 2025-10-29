package com.plush.lancet.weaver.internal.utils;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class AsmUtil {
    public static MethodNode clone(MethodNode node) {
        MethodNode clone = new MethodNode(Opcodes.ASM5, node.access, node.name, node.desc, node.signature, (String[]) node.exceptions.toArray(new String[node.exceptions.size()]));
        node.accept(clone);
        return clone;
    }
}
