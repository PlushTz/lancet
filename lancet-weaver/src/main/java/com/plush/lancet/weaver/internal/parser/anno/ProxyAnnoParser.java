package com.plush.lancet.weaver.internal.parser.anno;

import com.plush.lancet.weaver.internal.exception.IllegalAnnotationException;
import com.plush.lancet.weaver.internal.meta.HookInfoLocator;
import com.plush.lancet.weaver.internal.parser.AnnoParser;
import com.plush.lancet.weaver.internal.parser.AnnotationMeta;
import com.google.common.base.Strings;

import org.objectweb.asm.tree.AnnotationNode;

import java.util.List;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class ProxyAnnoParser implements AnnoParser {
    @SuppressWarnings("unchecked")
    @Override
    public AnnotationMeta parseAnno(AnnotationNode annotationNode) {
        List<Object> values;
        String targetMethod = null;
        if ((values = annotationNode.values) != null) {
            for (int i = 0; i < values.size(); i += 2) {
                switch ((String) values.get(i)) {
                    case "value":
                        targetMethod = (String) values.get(i + 1);
                        if (Strings.isNullOrEmpty(targetMethod)) {
                            throw new IllegalAnnotationException("@Proxy value can't be empty or null");
                        }

                        break;
                    default:
                        throw new IllegalAnnotationException();
                }
            }
            return new ProxyAnnoMeta(annotationNode.desc, targetMethod);
        }

        throw new IllegalAnnotationException("@Proxy is illegal, must specify value field");
    }

    public static class ProxyAnnoMeta extends AnnotationMeta {

        private final String targetMethod;

        private ProxyAnnoMeta(String desc, String targetMethod) {
            super(desc);
            this.targetMethod = targetMethod;
        }

        @Override
        public void accept(HookInfoLocator locator) {
            locator.setProxy(targetMethod);
        }
    }
}
