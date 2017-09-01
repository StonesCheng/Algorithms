import java.util.Scanner;

/**
 * Created by RayCheng on 2017/8/30.
 */
public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int len=scanner.nextInt();
        int[] ints=new int[len];
        String[] temp=scanner.nextLine().split(" ");
        for(int i=0;i<len;i++){
            ints[i]=Integer.parseInt(temp[i]);
        }
        int sum=scanner.nextInt();
    }
}