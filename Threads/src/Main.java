import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    private static ExecutorService executorService;
    static volatile String S = "A";
    private static final Object monitor=new Object();
    //1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.

    public static void main(String[] args) {
        try{
            executorService= Executors.newFixedThreadPool(3);
            executorService.execute(new myThread("Thread1","A"));
            executorService.execute(new myThread("Thread2","B"));
            executorService.execute(new myThread("Thread3","C"));
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class myThread implements Runnable{
        String name;
        String letter;

        public myThread(String name,String letter) {
            this.name = name;
            this.letter =letter;
            new Thread(this);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    while (!letter.equals(S)) {
                        try {
                            monitor.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(letter);
                    if(letter=="A"){
                        S="B";
                    } else if (letter=="B"){
                        S="C";
                    } else if (letter=="C"){
                        S="A";
                    }
                    monitor.notifyAll();
                }
            }
        }
    }
}
