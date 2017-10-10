package algorithms;

import java.util.Scanner;

/**
 * Created by RayCheng on 2017/8/23.
 */
public class Quick {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String in=scanner.nextLine();
        String[] temp=in.split(",");
        int[] input=new int[temp.length];
        for(int i=0;i<temp.length;i++)
            input[i]=Integer.valueOf(temp[i]);
        sort(input,0,input.length-1);
        for(int i=0;i<input.length-1;i++)
            System.out.print(input[i]+" ");
        System.out.print(input[input.length-1]);
    }
    private static void sort(int[]a,int lo,int hi){
        if(hi<lo) return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition_nice(int[]a,int lo,int hi){
        int i=lo,j=hi+1;
        int v=a[lo];
        while (true){
            while(a[++i]<v) if(i==hi) break;
            while(v<a[--j]) if(j==lo) break;
            if(i>=j) break;
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
        int temp=a[lo];
        a[lo]=a[j];
        a[j]=temp;
        return j;
    }
    static int partition(int[] array,int beg,int end){
        int last = array[end];
        int i = beg -1;
        for (int j = beg; j <= end-1; j++) {
            if(array[j] <= last){
                i++;
                if(i != j){
                    array[i] = array[i]^array[j];
                    array[j] = array[i]^array[j];
                    array[i] = array[i]^array[j];
                }
            }
        }
        if((i+1) != end){
            array[i+1] = array[i+1]^array[end];
            array[end] = array[i+1]^array[end];
            array[i+1] = array[i+1]^array[end];
        }
        return i+1;
    }
     /*private static int partition(int[]a,int lo,int hi){
        int flag=lo;
        for(int i=lo+1;i<hi+1;i++){
            if(a[lo]>a[i])
                flag=i;
        }
        int temp=a[flag];
        a[flag]=a[lo];
        a[lo]=temp;
        return flag;
    }*/
}
