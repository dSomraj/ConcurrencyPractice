public class Producer implements Runnable{
    private Store store;
    public Producer(Store store){
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
            while(store.getItems().size()<store.getMaxsize()){
                store.getItems().add(new Object());
                System.out.println(store.getItems().size()+"  "+Thread.currentThread().getName());
            }
        }
    }
}
