package SynchronizedKeyword;

public class Consumer implements Runnable{
    private Store store;
    public Consumer(Store store){
        this.store=store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        synchronized (store){
            while(store.getItems().size()>0){
                store.getItems().remove(store.getItems().size()-1);
                System.out.println(store.getItems().size()+"  "+Thread.currentThread().getName());
            }
        }
    }
}
