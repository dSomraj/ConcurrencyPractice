package Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Store store=new Store(5);
        Semaphore prodSema=new Semaphore(5);
        Semaphore conSema=new Semaphore(0);
        ExecutorService es=Executors.newCachedThreadPool();
        for(int i=0;i<8;i++){
            es.execute(new Producer(store,prodSema,conSema));
        }
        for(int i=0;i<20;i++){
            es.execute((new Consumer(store,prodSema,conSema)));
        }




    }
}