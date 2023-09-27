package com.umbrella.demo.sdk.java;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class MainTest {

    private final Class<?> mainClass;
    public MainTest() {
        this.mainClass = deduceMainApplicationClass();
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        Class<?> aClass = mainTest.getMainClass();
        System.out.println(aClass.getName());
    }


    public Class<?> getMainClass() {
        return mainClass;
    }

    private Class<?> deduceMainApplicationClass() {
        return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(this::findMainClass)
                .orElse(null);
    }

    private Optional<Class<?>> findMainClass(Stream<StackWalker.StackFrame> stack) {
        return stack.filter((frame) -> Objects.equals(frame.getMethodName(), "main"))
                .findFirst()
                .map(StackWalker.StackFrame::getDeclaringClass);
    }
}
