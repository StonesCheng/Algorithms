package concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastTest {
    private static List<Integer> list=new ArrayList<Integer>();
    private static class threadOne extends Thread{
        public void run(){
            Iterator<Integer> iterator=list.iterator();
            while (iterator.hasNext()){
                int i=iterator.next();
                System.out.println("ThreadOne 遍历:"+i);
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private static class threadTwo extends Thread{
        @Override
        public void run() {
            int i=0;
            while (i<6){
                System.out.println("ThreadTwo run:"+i);
                if(i==3){
                    list.remove(i);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++)
            list.add(i);
        new threadOne().start();
        new threadTwo().start();
    }
}
