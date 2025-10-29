package com.plush.lancet.weaver.internal;

import com.plush.lancet.weaver.ClassData;
import com.plush.lancet.weaver.Weaver;
import com.plush.lancet.weaver.internal.asm.ClassTransform;
import com.plush.lancet.weaver.internal.entity.TransformInfo;
import com.plush.lancet.weaver.internal.graph.Graph;
import com.plush.lancet.weaver.internal.log.Log;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class AsmWeaver implements Weaver {
    /**
     * Create a AsmWeaver instance. In a compilation process, the AsmWeaver instance will only be created once.
     *
     * @param transformInfo the transformInfo for this compilation process.
     * @param graph
     * @return
     */
    public static Weaver newInstance(TransformInfo transformInfo, Graph graph) {
        return new AsmWeaver(transformInfo, graph);
    }

    private final TransformInfo transformInfo;
    private final Graph graph;

    private AsmWeaver(TransformInfo transformInfo, Graph graph) {
        Log.d(transformInfo.toString());
        this.graph = graph;
        this.transformInfo = transformInfo;
    }

    @Override
    public ClassData[] weave(byte[] input, String relativePath) {
        if (!relativePath.endsWith(".class")) {
            throw new IllegalArgumentException("relativePath is not a class: " + relativePath);
        }
        String internalName = relativePath.substring(0, relativePath.lastIndexOf('.'));
        try {
            return ClassTransform.weave(transformInfo, graph, input, internalName);
        } catch (RuntimeException e) {
            Log.e("error in transform: " + relativePath, e);
            return new ClassData[]{new ClassData(input, internalName)};
        }
    }
}
