/**
 * Created by RayCheng on 2017/8/23.
 */

public class Merge {
    public static int[] aux;
    //自顶向下
    public static void main1(String[] args) {
        int[]a={7,6,5,4,3,2,1};
        aux=new int[a.length];
        sort(a,0,a.length-1);
        for(int i=0;i<a.length-1;i++)
            System.out.println(a[i]);
    }
    public static void main(String[] args) {
        int[] a={7,6,5,4,3,2,1};
        aux=new int[a.length];
        for(int sz=1;sz<a.length;sz=sz+sz)
            for(int lo=0;lo<a.length-sz;lo+=sz+sz)
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,a.length-1));
        for(int i=0;i<a.length-1;i++)
            System.out.println(a[i]);
    }
    public static void sort(int[]a,int lo,int hi){
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    public static void merge(int[] a,int lo,int mid,int hi){
        int i=lo;
        int j=mid+1;
        for(int k=lo;k<=hi;k++)
            aux[k]=a[k];
        for(int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(aux[j]<aux[i]) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }
}
