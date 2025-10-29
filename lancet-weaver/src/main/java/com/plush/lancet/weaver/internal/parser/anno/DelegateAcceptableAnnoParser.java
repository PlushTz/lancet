package com.plush.lancet.weaver.internal.parser.anno;

import com.plush.lancet.weaver.internal.parser.AcceptableAnnoParser;
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
public class DelegateAcceptableAnnoParser implements AcceptableAnnoParser {
    private final String desc;
    private final AnnoParser parser;

    public DelegateAcceptableAnnoParser(String desc, AnnoParser parser) {

        this.desc = desc;
        this.parser = parser;
    }

    @Override
    public boolean accept(String desc) {
        return this.desc.equals(desc);
    }

    @Override
    public AnnotationMeta parseAnno(AnnotationNode annotationNode) {
        return parser.parseAnno(annotationNode);
    }
}
