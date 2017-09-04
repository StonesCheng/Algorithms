import java.util.*;

/**
 * Created by RayCheng on 2017/8/30.
 */
public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int sugar=scanner.nextInt();
        if(sugar<=0|num<=0) return;
        int[] sugars=new int[sugar];
        for(int i=0;i<sugar;i++) {
            sugars[i] = scanner.nextInt();
        }
        Map<Integer,Integer> temp=new TreeMap<>();
        char[] temp1=new char[2];
        for(int i=0;i<num;i++){
            temp1=scanner.nextLine().split(" ").toString().toCharArray();
            temp.put(Integer.parseInt(String.valueOf(temp1[0])),Integer.parseInt(String.valueOf(temp1[2])));
        }
        Iterable it= (Iterable) temp.keySet();
    }
}