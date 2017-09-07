package algorithms;

/**
 * Created by RayCheng on 2017/9/1.
 */
public class test13 {
    public static void main(String[] args) {
        int [] test={2,4,6,1,3,5,7};
        reOrderArray(test);
        for(int i=0;i<test.length;i++)
            System.out.println(test[i]);
    }
    public static void reOrderArray(int [] array) {
        int[] temp=new int[array.length];
        int a=0;int b=array.length-1;
        for(int i=0,j=array.length-1;i<array.length&j>=0;i++,j--){
            if(array[i]%2==1)
                temp[a++]=array[i];
            if(array[j]%2==0)
                temp[b--]=array[j];
        }
        for(int i=0;i<array.length;i++)
            array[i]=temp[i];
    }
}
