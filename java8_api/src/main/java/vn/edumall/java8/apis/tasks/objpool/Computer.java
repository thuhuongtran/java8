package vn.edumall.java8.apis.tasks.objpool;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter @Setter
public class Computer {
    private static final AtomicInteger id = new AtomicInteger(0);
    private String code;

    public Computer() {
        id.incrementAndGet();
        this.code = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(0, 6);
    }
}
