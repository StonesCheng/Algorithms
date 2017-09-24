import java.util.*;

/**
 * Created by RayCheng on 2017/9/12.
 */
public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] temp=new int[n];
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            temp[i] = scanner.nextInt();
            set.add(temp[i]);
        }
        Integer[] temp1=set.toArray(new Integer[] {});
        int[] temp2=new int[temp1.length];
        for(int i=0;i<temp1.length;i++) {
            temp2[i] = temp1[i].intValue();
        }
        Arrays.sort(temp2);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<temp2.length;i++)
            map.put(temp2[i],i+1);
        for(int i=0;i<n-1;i++)
            System.out.print(map.get(temp[i])+" ");
        System.out.println(map.get(temp[n-1]));
    }
}
