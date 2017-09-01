/**
 * Created by RayCheng on 2017/8/30.
 */
public class test12 {
    public static void main(String[] args) {
        System.out.println(Power1(2,10));
    }
    public static double Power(double base, int exponent) {
        int flag=0;
        if(exponent==0)
            return 1;
        else if(exponent==1)
            return base;
        else {
            if(exponent<0) {base=1/base; exponent=-exponent;}
            double sum=base;
            exponent=exponent-1;
            while (exponent != 0) {
                if(sum>=Double.MAX_VALUE) break;
                sum *= sum;
                exponent--;
                if(exponent==0)
                    break;
                if (exponent% 2 == 0) {
                    exponent/=2;
                }
                else{
                    flag++;
                    exponent--;
                    if(exponent==0) break;
                }
            }
            for(int i=0;i<flag;i++)
                sum*=base;
            return sum;
        }
    }
    public static double Power1(double base,int exponent)  {
        double sum=1;
        double curr=base;
        int flag=exponent;
        if(exponent>0)
            exponent=exponent;
        else if(exponent<0){
            if(base==0)
                throw new RuntimeException("分母不能为零");
            exponent=-exponent;
        }
        else
            return 1;
        while (exponent!=0){
            if((exponent&1)==1)
                sum*=curr;
            curr*=curr;
            exponent>>=1;
        }
        return flag>0?sum:1/sum;
    }
}
