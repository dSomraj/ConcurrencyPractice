package Semaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Store store;
    private Semaphore prodSema;
    private Semaphore conSema;
    public Producer(Store store, Semaphore prodSema, Semaphore conSema){
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
            prodSema.acquire();
            Thread.sleep(10);
        }
        catch (Exception e){
            throw new RuntimeException();
        }
        store.addItem(new Object());
        conSema.release();
    }
}
