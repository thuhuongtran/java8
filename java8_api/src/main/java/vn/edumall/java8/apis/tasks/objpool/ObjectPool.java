package vn.edumall.java8.apis.tasks.objpool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class ObjectPool<T> {
    private int maxPoolSize;
    private List<T> available;
    private List<T> inUse;

    protected abstract T create();

    public ObjectPool(int minPoolSize, int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        available = new ArrayList<>();
        inUse = new ArrayList<>();
        IntStream.range(0, minPoolSize).parallel().forEach(
                i -> {
                    T obj = create();
                    available.add(obj);
                }
        );
    }

    public T getObj() {
        T obj= null;
        if(available.size() > 0){
            obj = available.get(0);
            available.remove(obj);
            inUse.add(obj);
        }
        else{
            // need create more object
            if (available.size() + inUse.size() < maxPoolSize) {
                obj = create();
                available.add(obj);
            }
        }
        return obj;
    }

    public void returnObj(T obj) {
        available.add(obj);
        inUse.remove(obj);
    }
}
