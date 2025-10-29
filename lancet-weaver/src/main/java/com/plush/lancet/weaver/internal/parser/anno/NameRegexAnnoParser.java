package com.plush.lancet.weaver.internal.parser.anno;

import com.plush.lancet.weaver.internal.exception.IllegalAnnotationException;
import com.plush.lancet.weaver.internal.meta.HookInfoLocator;
import com.plush.lancet.weaver.internal.parser.AnnoParser;
import com.plush.lancet.weaver.internal.parser.AnnotationMeta;
import com.plush.lancet.weaver.internal.utils.RefHolder;
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
public class NameRegexAnnoParser implements AnnoParser {
    @SuppressWarnings("unchecked")
    @Override
    public AnnotationMeta parseAnno(AnnotationNode annotationNode) {
        List<Object> values;
        RefHolder<String> regex = new RefHolder<>(null);
        if ((values = annotationNode.values) != null) {
            for (int i = 0; i < values.size(); i += 2) {
                switch ((String) values.get(i)) {
                    case "value":
                        regex.set((String) values.get(i + 1));
                        if (Strings.isNullOrEmpty(regex.get())) {
                            throw new IllegalAnnotationException("@NameRegexAnnoParser value can't be empty or null");
                        }

                        break;
                    default:
                        throw new IllegalAnnotationException();
                }
            }
            return new AnnotationMeta(annotationNode.desc) {
                @Override
                public void accept(HookInfoLocator locator) {
                    locator.setNameRegex(regex.get());
                }
            };
        }

        throw new IllegalAnnotationException("@NameRegexAnnoParser is illegal, must specify value field");
    }
}
