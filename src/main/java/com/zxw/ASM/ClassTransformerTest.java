package com.zxw.ASM;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * @Author: Ryan
 * @Date: 2021/5/11 18:20
 * @Version: 1.0
 * @Description:
 */
public class ClassTransformerTest {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/zxw/ASM/Tank.class")
        );

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) { // 自定义 visitor 在原有的 writer 增加一些代码（修改代码通过二进制文件）
            @Override
            public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
                MethodVisitor mv = super.visitMethod(i, s, s1, s2, strings);

                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "TimeProxy", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

//        cr.accept(cw, 0); // 这就是复制原有的类
        cr.accept(cv, 0); // 复制以及增强
        byte[] b2 = cw.toByteArray();
        String path = (String) System.getProperties().get("user.dir");
        File file = new File(path + "/com/zxw/ASM/");
        file.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/zxw/ASM/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();
    }
}
