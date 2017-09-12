package algorithms;

import java.util.Scanner;

/**
 * Created by RayCheng on 2017/8/30.
 */
public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String in=scanner.nextLine();
        System.out.println(Solution(in));
    }
    static int flag=0;
    public static int Solution(String in){
        char[] temp=in.toCharArray();
        int match=temp.length/2;
        int[] num=new int[match];
        for(int i=0;i<match;i++)
            num[i]=0;
        solu(temp,num);
        int sum=1;
        for(int i=0;i<match;i++)
            System.out.println(num[i]);
        for(int i=0;i<match;i++)
            if(num[i]==0)
                break;
            else
                sum*=num[i];
        return sum;
    }
    public static void solu(char[] in,int[] num){
        for(int i=flag+1;i<in.length;i++){
            if(in[i]==')'){
                int b=1;
                int test=0;
                num[test]=1;
                if(i+b>=in.length) break;
                while(in[i+b]==')'){
                    if(in.length-1-(i+b)>0) {
                        num[test]++;
                        b++;
                    }
                    else
                        break;
                }
                flag=i+b;
                while(in[flag]!=')')
                    flag++;
                test++;
            }
        }
    }
}