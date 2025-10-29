package com.plush.lancet.plugin.internal.preprocess;

import com.plush.lancet.weaver.internal.graph.ClassEntity;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public interface PreClassProcessor {
    ProcessResult process(byte[] classBytes);

    class ProcessResult {


        public ProcessResult(boolean isHookClass, ClassEntity entity) {
            this.isHookClass = isHookClass;
            this.entity = entity;
        }

        public boolean isHookClass;
        public ClassEntity entity;

        @Override
        public String toString() {
            return "ProcessResult{" +
                    "isHookClass=" + isHookClass +
                    ", entity=" + entity +
                    '}';
        }
    }
}
