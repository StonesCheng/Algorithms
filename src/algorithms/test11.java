package algorithms;

public class test11 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(10));
    }
    public static int NumberOf1(int n) {
        int i=0;
        while(n!=0){
            i+=n&1;
            n=n>>>1;
        }
        return i;
    }
}
