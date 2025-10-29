package com.plush.lancet.weaver.internal.parser;

import org.objectweb.asm.tree.AnnotationNode;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public interface AnnoParser {
    AnnotationMeta parseAnno(AnnotationNode annotationNode);
}
