package junit;

public class Test {
    private int a;
    private int b;
    Test(int c,int d){
        a=c;
        b=d;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    public int addAB(){
        return a+b;
    }
    public long multiAB(){
        return a*b;
    }
}

