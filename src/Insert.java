import java.util.Scanner;

public class Insert {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] t=new int[n];
        for(int i=0;i<n;i++)
            t[i]=scanner.nextInt();
        for(int i=1;i<n;i++){
            for(int j=i; j>0 && t[j]<t[j-1];j--){
                int temp=t[j-1];
                t[j-1]=t[j];
                t[j]=temp;
            }
        }
        for(int i=0;i<n;i++)
            System.out.println(t[i]);
    }

}
