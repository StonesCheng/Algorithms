package concurrent;

/**
 * Created by RayCheng on 2017/9/7.
 */
public class Stage extends Thread {
    public void run(){
        ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();
        Thread armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt=new Thread(armyTaskOfRevolt,"农民军");
        armyOfSuiDynasty.start();
        armyOfRevolt.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        armyTaskOfRevolt.keepRunning=false;
        armyTaskOfSuiDynasty.keepRunning=false;
        try {
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Stage().start();
    }
}
