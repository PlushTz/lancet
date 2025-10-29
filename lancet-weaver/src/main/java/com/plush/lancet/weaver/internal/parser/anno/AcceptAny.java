package com.plush.lancet.weaver.internal.parser.anno;

import com.plush.lancet.weaver.internal.log.Log;
import com.plush.lancet.weaver.internal.meta.HookInfoLocator;
import com.plush.lancet.weaver.internal.parser.AcceptableAnnoParser;
import com.plush.lancet.weaver.internal.parser.AnnotationMeta;

import org.objectweb.asm.tree.AnnotationNode;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class AcceptAny implements AcceptableAnnoParser {
    public static AcceptAny INSTANCE = new AcceptAny();

    private AcceptAny(){
    }

    @Override
    public boolean accept(String desc) {
        return true;
    }

    @Override
    public AnnotationMeta parseAnno(AnnotationNode annotationNode) {
        Log.w("Annotation " + annotationNode.desc + " is lost.");
        return new AnnotationMeta(annotationNode.desc) {

            @Override
            public void accept(HookInfoLocator locator) {
            }
        };
    }
}
