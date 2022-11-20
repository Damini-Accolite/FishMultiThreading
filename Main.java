import java.util.*;
public class Main {
    public static void main(String[] args) {
        Thread t1= new Thread(new Fish());
        t1.start();
        Thread t2= new Thread(new Fish());
        t2.start();
        Thread t3= new Thread(new Fish());
        t3.start();
        Thread t4= new Thread(new Fish());
        t4.start();
        Thread t5= new Thread(new Fish());
        t5.start();
        try {
            t3.join();
            t1.sleep(3000);
            t2.join();
            t5.sleep(4000);
            t4.join();
            t5.join();
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Exiting main method");
    }
}