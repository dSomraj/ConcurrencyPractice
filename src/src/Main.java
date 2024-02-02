import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Store store=new Store(50);
//        Producer producer=new Producer(store);
//        Consumer consumer=new Consumer(store);

        ExecutorService es= Executors.newFixedThreadPool(20);
        for(int i=1;i<=80;i++){
            es.execute(new Producer(store));
        }
        for(int i=1;i<=2000;i++){
            es.execute(new Consumer(store));
        }



    }
}