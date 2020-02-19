package vn.edumall.java8.apis.tasks.patterns;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.stream.IntStream;

public class ObjectPoolTest {
    /**
     * Will print 0 1 2 3 4 5 6 7 8 9
     * Duration: > 10s
     */
    @Test
    public void testJava8ForLoop() {
        long start = System.currentTimeMillis();
        IntStream.range(0, 10).forEach(
                i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(i);
                }
        );
        System.out.printf("\nDuration=%d", System.currentTimeMillis() - start);
    }

    /**
     * Will print indexes aren't in sorted: 6 4 1 5 8 2 0 7 3 9
     * Durations: > 2s
     */
    @Test
    public void testJava8ForLoopWithParallel() {
        long start = System.currentTimeMillis();
        IntStream.range(0, 10).parallel().forEach(
                i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(i);
                }
        );
        System.out.printf("\nDuration=%d", System.currentTimeMillis() - start);
    }

    @Test
    public void testStuff() {
        String str = Long.toHexString(Double.doubleToLongBits(Math.random()));
        System.out.println(str);
    }
}
