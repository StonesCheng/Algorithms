package concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;

@ThreadSafe
public class NoVisibility {
    private  static ArrayList<Integer> test=new ArrayList<Integer>();
    private static class ReaderThread extends Thread{
        public void run(){
            for(int i=0;i<test.size();i++){
                test.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        synchronized(test){
            for(int i=test.size();i>0;i++){
                System.out.println(test.get(i));
                test.add(i);
            }
        }
    }
}
