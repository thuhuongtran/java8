package vn.edumall.java8.apis.tasks.objpool;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter @Setter
public class Bullet {
    public static final AtomicInteger id = new AtomicInteger(0);
    private String code;
    private int index;

    public Bullet() {
        this.index = id.incrementAndGet();
        this.code = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(3, 9);
        System.out.print(" | id = "+this.index+", code = "+this.code);
    }
}
