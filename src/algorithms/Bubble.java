package algorithms;

import java.util.Scanner;

/**
 * Created by RayCheng on 2017/8/21.
 */
public class Bubble {
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] t=new int[n];
        for(int i=0;i<n;i++)
            t[i]=scanner.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(t[j+1]<t[j]) {
                    int temp = t[j];
                    t[j] = t[j+1];
                    t[j+1] = temp;
                }
            }
        }
        for(int i=0;i<n;i++)
            System.out.println(t[i]);
    }
}
