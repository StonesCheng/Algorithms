package algorithms;

public class test6 {
    public static void main(String[] args) {
        int[] test={3,4,5,1,2};
        System.out.println(minNumberInRotateArray2(test));
    }
    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return 0;
        else{
            int flag=0;
            for(int i=1;i<array.length;i++){
                if(array[flag]>array[i])
                    flag=i;
            }
            return array[flag];
        }
    }
    public static int minNumberInRotateArray1(int [] array) {
        if(array.length==0)
            return 0;
        for(int i=0;i<array.length;i++)
            if(array[i]>array[i+1])
                return array[i+1];
        return array[0];
    }
    public static int minNumberInRotateArray2(int [] array) {
        if(array.length==0)
            return 0;
        int left=0;
        int right=array.length-1;
        int mid=0;
        while (array[left]>=array[right]){
            if(right-left==1){
                mid=right;
                break;
            }
            mid=left+(right-left)/2;
            if(array[mid]>=array[left])
                left=mid;
            if(array[mid]<=array[right])
                right=mid;
        }
        return array[mid];
    }
}

