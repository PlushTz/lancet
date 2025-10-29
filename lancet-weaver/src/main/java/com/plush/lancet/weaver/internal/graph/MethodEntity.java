package com.plush.lancet.weaver.internal.graph;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class MethodEntity {
    public int access;
    public String name;
    public String desc;

    public MethodEntity(int access, String name, String desc) {
        this.access = access;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "MethodEntity{" + "access=" + access + ", name='" + name + '\'' + ", desc='" + desc + '\'' + '}';
    }
}
