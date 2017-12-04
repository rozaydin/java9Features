package com.rhtech.jshell;

import java.util.stream.IntStream;

public class JShellExample {
    public void sayHello() {
        System.out.println("Hello World!");
    }

    public int sumNumbers(int... numbers) {
        return IntStream.of(numbers).sum();
    }
}
