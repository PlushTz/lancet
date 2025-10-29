package com.plush.lancet.plugin.internal.preprocess;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public class AsmClassProcessorImpl implements PreClassProcessor {
    @Override
    public PreClassProcessor.ProcessResult process(byte[] classBytes) {
        ClassReader cr = new ClassReader(classBytes);
        PreProcessClassVisitor cv = new PreProcessClassVisitor(Opcodes.ASM5);
        cr.accept(cv, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
        return cv.getProcessResult();
    }
}
