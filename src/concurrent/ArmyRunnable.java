package concurrent;

/**
 * Created by RayCheng on 2017/9/7.
 */
public class ArmyRunnable implements Runnable {
    volatile boolean keepRunning;
    @Override
    public void run() {
        while (keepRunning){
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束战斗");
    }
}
