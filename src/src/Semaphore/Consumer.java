package Semaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Store store;
    private Semaphore prodSema;
    private Semaphore conSema;
    public Consumer(Store store, Semaphore prodSema, Semaphore conSema){
        this.store=store;
        this.prodSema=prodSema;
        this.conSema=conSema;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
            try {
                conSema.acquire();
                Thread.sleep((10));
            }
            catch (Exception e){
                throw new RuntimeException();
            }
            store.deleteItem();
            prodSema.release();
    }
}
