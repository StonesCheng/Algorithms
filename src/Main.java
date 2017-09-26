import java.util.Scanner;

/**
 * Created by RayCheng on 2017/9/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] temp=new int[n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                temp[i][j]=scanner.nextInt();
        for(int i=0;i<n;i++)
            handle(temp[i][0],temp[i][1],i+1);
    }
    public static void handle(int ints1,int ints2,int x ){
        String a=Integer.toBinaryString(ints2);
        char[] b=a.toCharArray();
        int index=b.length;
        while (index>0) {
            int flag=index;
            StringBuffer stringBuffer=new StringBuffer();
            for(int i=0;i<b.length-flag;i++)
                stringBuffer.append(0);
            for(int i=0;i<flag;i++)
                stringBuffer.append(1);
            int d = Integer.valueOf(stringBuffer.toString(),2);
            if(d<=ints2&d>=ints1) {
                System.out.println("Case " + x + ": " + d);
                break;
            }
            else{
                StringBuffer stringBuffer2=new StringBuffer();
                stringBuffer2.append(1);
                stringBuffer2.append(0);
                for(int i=0;i<b.length-2;i++)
                    stringBuffer2.append(1);
                System.out.println(stringBuffer2.toString());
                int e = Integer.valueOf(stringBuffer2.toString(),2);
                if(d<=ints2&d>=ints1) {
                    System.out.println("Case " + x + ": " + e);
                    break;
                }
            }
            index--;
        }
    }
}
