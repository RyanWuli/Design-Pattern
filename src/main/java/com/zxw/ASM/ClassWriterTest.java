package com.zxw.ASM;


import jdk.internal.org.objectweb.asm.ClassWriter;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

/**
 * @Author: Ryan
 * @Date: 2021/5/11 18:09
 * @Version: 1.0
 * @Description: 读文件二进制码
 */
public class ClassWriterTest {

    public static void main(String[] args) {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable", null, "java/lang/Object",
                null);
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray();

        MyClassLoader mc = new MyClassLoader();
        Class aClass = mc.defineClass("pkg.Comparable", b);
        System.out.println(aClass.getMethods()[0].getName());
    }
}
