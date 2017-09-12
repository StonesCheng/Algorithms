package concurrent;

/**
 * Created by RayCheng on 2017/9/7.
 */
public class Actor extends Thread{
    @Override
    public void run() {
        System.out.println(getName()+" is a actor");
        int count=0;
        boolean keepRunning=true;
        while (keepRunning) {
            System.out.println(getName() + " show times " + (++count));
            if(count==100)
                keepRunning=false;
            if(count%10==0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName()+"game is over");
    }

    public static void main(String[] args) {
        Thread actor=new Actor();
        actor.setName("Mr.Thread");
        actor.start();
        Thread actress=new Thread(new Actress(),"Ms.Runnable");
        actress.start();
    }
}
class Actress implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread()+" is a actor");
        int count=0;
        boolean keepRunning=true;
        while (keepRunning) {
            System.out.println(Thread.currentThread() + " show times " + (++count));
            if(count==100)
                keepRunning=false;
            if(count%10==0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread()+"game is over");
    }
}
