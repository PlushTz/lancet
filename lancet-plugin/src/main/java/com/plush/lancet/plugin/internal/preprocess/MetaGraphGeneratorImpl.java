package com.plush.lancet.plugin.internal.preprocess;

import com.android.build.api.transform.Status;
import com.plush.lancet.weaver.internal.graph.CheckFlow;
import com.plush.lancet.weaver.internal.graph.ClassEntity;
import com.plush.lancet.weaver.internal.graph.ClassNode;
import com.plush.lancet.weaver.internal.graph.Graph;
import com.plush.lancet.weaver.internal.graph.InterfaceNode;
import com.plush.lancet.weaver.internal.graph.MetaGraphGenerator;
import com.plush.lancet.weaver.internal.graph.Node;

import org.objectweb.asm.Opcodes;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class MetaGraphGeneratorImpl implements MetaGraphGenerator {
    private final CheckFlow checkFlow;
    // Key is class name. value is class node.
    private Map<String, Node> nodeMap = new ConcurrentHashMap<>(512);
    private Graph graph;

    public MetaGraphGeneratorImpl(CheckFlow checkFlow) {
        this.checkFlow = checkFlow;
    }

    // thread safe
    public void add(ClassEntity entity, Status status) {
        Node current = getOrPutEmpty((entity.access & Opcodes.ACC_INTERFACE) != 0, entity.name);

        ClassNode superNode = null;
        List<InterfaceNode> interfaceNodes = Collections.emptyList();
        if (entity.superName != null) {
            superNode = (ClassNode) getOrPutEmpty(false, entity.superName);
        }
        if (entity.interfaces.size() > 0) {
            interfaceNodes = entity.interfaces.stream().map(i -> (InterfaceNode) getOrPutEmpty(true, i)).collect(Collectors.toList());
        }

        current.entity = entity;
        current.parent = superNode;
        current.status = status;
        current.interfaces = interfaceNodes;
    }

    public void remove(String className) {
        nodeMap.remove(className);
    }

    // find node by name, if node is not exist then create and add it.
    private Node getOrPutEmpty(boolean isInterface, String className) {
        return nodeMap.computeIfAbsent(className, n -> isInterface ? new InterfaceNode(n) : new ClassNode(n));
    }


    List<ClassEntity> toLocalNodes() {
        return nodeMap.values().stream().filter(it -> it.parent != null).map(it -> it.entity).collect(Collectors.toList());
    }

    @Override
    public Graph generate() {
        if (graph == null) {
            graph = new Graph(nodeMap, checkFlow);
            graph.prepare();
        }
        return graph;
    }
}
