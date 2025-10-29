package com.plush.lancet.weaver.internal.parser.anno;

import com.plush.lancet.base.Scope;
import com.plush.lancet.weaver.internal.exception.IllegalAnnotationException;
import com.plush.lancet.weaver.internal.meta.HookInfoLocator;
import com.plush.lancet.weaver.internal.parser.AnnoParser;
import com.plush.lancet.weaver.internal.parser.AnnotationMeta;
import com.plush.lancet.weaver.internal.utils.RefHolder;
import com.google.common.base.Strings;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class TargetClassAnnoParser implements AnnoParser {
    private static final String ENUM_DESC = Type.getDescriptor(Scope.class);


    @SuppressWarnings("unchecked")
    @Override
    public AnnotationMeta parseAnno(AnnotationNode annotationNode) {
        RefHolder<String> className = new RefHolder<>(null);
        RefHolder<Scope> scope = new RefHolder<>(Scope.SELF);

        List<Object> values;
        if ((values = annotationNode.values) != null) {
            for (int i = 0; i < values.size(); i += 2) {
                switch ((String) values.get(i)) {
                    case "value":
                        String temp = (String) values.get(i + 1);
                        if (Strings.isNullOrEmpty(temp)) {
                            throw new IllegalAnnotationException("@TargetClass value can't be empty or null");
                        }
                        className.set(temp.replace('.', '/'));
                        break;
                    case "scope":
                        String[] vs = (String[]) values.get(i + 1);
                        if (!ENUM_DESC.equals(vs[0])) {
                            throw new IllegalAnnotationException();
                        }
                        scope.set(Scope.valueOf(vs[1]));
                        break;
                    default:
                        throw new IllegalAnnotationException();
                }
            }

            return new AnnotationMeta(annotationNode.desc) {
                @Override
                public void accept(HookInfoLocator locator) {
                    computeClass(locator, className.get(), scope.get());
                }
            };
        }

        throw new IllegalAnnotationException("@TargetClass is illegal, must specify value field");
    }

    private void computeClass(HookInfoLocator locator, String className, Scope scope) {
        locator.mayAddCheckFlow(className, scope);
        Set<String> classes = new HashSet<>();
        locator.graph().childrenOf(className, scope).forEach(node -> {
            classes.add(node.entity.name);
        });
        locator.intersectClasses(classes);
    }
}
