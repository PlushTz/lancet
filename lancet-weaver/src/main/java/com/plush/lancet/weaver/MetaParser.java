package com.plush.lancet.weaver;

import com.plush.lancet.weaver.internal.entity.TransformInfo;
import com.plush.lancet.weaver.internal.graph.Graph;

import java.util.List;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public interface MetaParser {
    TransformInfo parse(List<String> classes, Graph graph);
}
