package Semaphore;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxsize;
    private List<Object> items;
    public Store(int maxsize){
        this.maxsize=maxsize;
        items=new ArrayList<>();
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }
    public void addItem(Object item){
        items.add(item);
        System.out.println(items.size()+" "+Thread.currentThread().getName());
    }
    public void deleteItem(){
        items.remove(items.size()-1);
        System.out.println(items.size()+" ");
    }

}
