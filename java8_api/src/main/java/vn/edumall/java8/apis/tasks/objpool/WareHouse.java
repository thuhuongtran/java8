package vn.edumall.java8.apis.tasks.objpool;

public class WareHouse extends ObjectPool<Computer> {

    public WareHouse(int minPoolSize, int maxPoolSize) {
        super(minPoolSize, maxPoolSize);
    }

    @Override
    protected Computer create() {
        return new Computer();
    }
}
