package algorithms;

import java.util.Scanner;

/**
 * Created by RayCheng on 2017/8/21.
 */
public class Select {
    public  static void main1(String [] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] t=new int[n];
        for(int i=0;i<n;i++)
            t[i]=scanner.nextInt();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(t[j]<t[i]) {
                    int temp = t[i];
                    t[i] = t[j];
                    t[j] = temp;
                }
            }
        }
        for(int i=0;i<n;i++)
            System.out.println(t[i]);
    }

    public  static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] t=new int[n];
        for(int i=0;i<n;i++)
            t[i]=scanner.nextInt();
        for(int i=0;i<n;i++){
            int flag=i;
            for(int j=i+1;j<n;j++){
                if(t[j]<t[i]) {
                   flag=j;
                }
                int temp = t[flag];
                t[flag] = t[i];
                t[i] = temp;
            }
        }
        for(int i=0;i<n;i++)
            System.out.println(t[i]);
    }
}
