package com.plush.lancet.weaver.internal.asm;

import com.plush.lancet.weaver.internal.graph.Graph;

import org.objectweb.asm.ClassVisitor;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class ClassContext {
    private final Graph graph;
    private final MethodChain chain;
    private final ClassVisitor tail;

    public String name;
    public String superName;

    public ClassContext(Graph graph, MethodChain chain, ClassVisitor tail) {
        this.graph = graph;
        this.chain = chain;
        this.tail = tail;
    }

    public ClassVisitor getTail() {
        return tail;
    }

    public Graph getGraph() {
        return graph;
    }

    public MethodChain getChain() {
        return chain;
    }
}
