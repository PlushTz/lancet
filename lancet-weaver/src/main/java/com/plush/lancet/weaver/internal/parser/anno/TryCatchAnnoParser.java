package com.plush.lancet.weaver.internal.parser.anno;

import com.plush.lancet.weaver.internal.meta.HookInfoLocator;
import com.plush.lancet.weaver.internal.parser.AnnoParser;
import com.plush.lancet.weaver.internal.parser.AnnotationMeta;

import org.objectweb.asm.tree.AnnotationNode;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class TryCatchAnnoParser implements AnnoParser {
    @Override
    public AnnotationMeta parseAnno(AnnotationNode annotationNode) {
        return new TryCatchAnnoMeta(annotationNode.desc);
    }

    public class TryCatchAnnoMeta extends AnnotationMeta {


        public TryCatchAnnoMeta(String desc) {
            super(desc);
        }

        @Override
        public void accept(HookInfoLocator locator) {
            locator.setTryCatch();
        }
    }
}
