package vn.edumall.java8.apis.tasks.objpool;

public class Executor {
    public static void main(String[] args) {
        WareHouse wh = new WareHouse(10, 20);
        Computer com = wh.getObj();
        wh.returnObj(com);
    }
}
