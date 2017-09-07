package algorithms;

/**
 * Created by RayCheng on 2017/8/23.
 */
public class Quick {
    public static void main(String[] args) {
        int[]a={10,9,8,7,6,5,4,3,2,1};
        sort(a,0,a.length-1);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
    private static void sort(int[]a,int lo,int hi){
        if(hi<lo) return;
        int j=partition_nice(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition(int[]a,int lo,int hi){
        int flag=lo;
        for(int i=lo+1;i<hi+1;i++){
            if(a[lo]>a[i])
                flag=i;
        }
        int temp=a[flag];
        a[flag]=a[lo];
        a[lo]=temp;
        return flag;
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
}
