package vn.edumall.java8.apis.tasks.objpool;

import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {
        WareHouse wh = new WareHouse(10, 20);
        Scanner sc = new Scanner(System.in);
        long start = System.currentTimeMillis();
        while (!sc.nextLine().equals("end")) {
            if (wh.getObj() == null) break;
            // after 5 second return obj to pool
            if (System.currentTimeMillis() - start >= 5000) {
                wh.returnObj(wh.getInUse().get(0));
            }
        }
    }
}
