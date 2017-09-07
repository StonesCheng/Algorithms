package algorithms;

public class test7 {
    public static void main(String[] args) {
        System.out.println(Fibonacci1(8));
    }
    public static  int Fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static int Fibonacci1(int n){
        int n1=1,n2=1;
        int sum=0;
        if(n==1|n==2) return 1;
        for(int i=3;i<=n;i++){
            sum=n1+n2;
            n1=n2;
            n2=sum;
        }
        return sum;
    }
}
