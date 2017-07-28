package com.CJFI.ch01.sec01;

/**
 * @author: pgajjar
 * @since: 3/10/17
 */
public class TestChild extends Test {
    public TestChild(int a, int b) {
        super(a, b);
        x = a * 10;
        y = b * 10;
    }

    public static Test getTest(Integer a, Integer b) {
        return new TestChild(a, b);
    }

    public static int multiply(Test t) {
        return (t.x * t.y) + 100;
    }
}
