package algorithms;

/**
 * Created by RayCheng on 2017/8/22.
 */
public class test1 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(1, arr));
    }
    public static boolean Find(int target, int[][]array) {
        int rows = array.length;
        int columns = array[0].length;
        if(rows==0|columns==0)
            return false;
        for (int i = rows-1, j = 0; i >=0 &&j < columns;) {
            if (array[i][j] == target)
                return true;
             if (target > array[i][j]) {
                j++;
                continue;
            }
            if(target<array[i][j]){
                i--;
                continue;
            }
        }
        return false;
    }
    /*public static boolean Find(int target, int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        boolean flag = false;
        if(rows>0&columns>0) {
            for (int i = 0; i < rows; i++) {
                flag = two(target, array, (columns - 1) / 2, 0, columns - 1, i);
                if (flag) break;
            }
        }
        return flag;
    }

    public static boolean two(int target, int[][] array, int mid, int lo, int hi, int i) {
        if (target > array[i][mid]) {
            lo = mid + 1;
            mid = (hi - mid) / 2 + mid;
            if (lo> hi)
                return false;
            else
                return two(target, array, lo, mid, hi, i);
        }
        if (target < array[i][mid]) {
            hi = mid - 1;
            mid = mid / 2;
            if(hi<lo)
                return false;
            else
                return two(target, array, lo, mid, hi, i);
        }
        if (target == array[i][mid])
            return true;
        else
            return false;
    }*/
}
