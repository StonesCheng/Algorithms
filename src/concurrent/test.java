package concurrent;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

public class test {

    public static void main(String[] args) throws InterruptedException {
        Timer timer=new Timer();
        timer.schedule(new ThrowTask(),1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(),1);
        SECONDS.sleep(5);
        /*int a=10;
        CountDownLatch countDownLatch=new CountDownLatch(a);
        FutureTask<String> futureTask=new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        Semaphore semaphore=new Semaphore(a);
        CyclicBarrier cyclicBarrier=new CyclicBarrier(a);
        Exchanger exchanger=new Exchanger();
        Timer timer=new Timer();*/
    }
    static class ThrowTask extends TimerTask{
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
