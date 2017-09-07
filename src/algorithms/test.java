package algorithms;

/**
 * Created by RayCheng on 2017/8/30.
 */
public class test {
    static volatile int i = 0;

    public static class PlusTask implements Runnable {
        public void run() {
            for (int k = 0; k < 10000; k++)
                synchronized (PlusTask.class) {
                    i++;
                }
        }

        public static void main(String[] args) throws InterruptedException {
            Thread[] thread = new Thread[10];
            for (int i = 0; i < 10; i++) {
                thread[i] = new Thread(new PlusTask());
                thread[i].start();
            }
            for (int i = 0; i < 10; i++)
                thread[i].join();
            System.out.println(i);
        }
    }
}