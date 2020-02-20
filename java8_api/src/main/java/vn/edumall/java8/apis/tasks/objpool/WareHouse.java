package vn.edumall.java8.apis.tasks.objpool;

public class WareHouse extends ObjectPool<Bullet> {

    public WareHouse(int minPoolSize, int maxPoolSize) {
        super(minPoolSize, maxPoolSize);
    }

    @Override
    protected Bullet create() {
        return new Bullet();
    }

    @Override
    public Bullet getObj() {
        Bullet bullet = super.getObj();
        if(bullet == null){
            System.out.println("Run out of bullets. Game over");
            return null;
        }
        System.out.print(" | id = "+bullet.getIndex()+" , code = "+bullet.getCode());
        return bullet;
    }
}
