package com.plush.lancet.weaver.internal.meta;

import com.plush.lancet.weaver.internal.parser.AnnotationMeta;

import org.objectweb.asm.tree.MethodNode;

import java.util.List;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class MethodMetaInfo {
    public MethodNode sourceNode;
    public List<AnnotationMeta> metaList;

    public MethodMetaInfo(MethodNode sourceNode) {
        this.sourceNode = sourceNode;
    }
}
