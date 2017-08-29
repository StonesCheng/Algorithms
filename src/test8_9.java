public class test8_9 {
    public static void main(String[] args) {
        System.out.println(jumpFloor(3));
    }
    public static int jumpFloor(int target){
        if(target==1) return 1;
        if(target==2) return 2;
        return jumpFloor(target-1)+jumpFloor(target-2);
    }
    public static int jumpFloor2(int target){
        if(target==1) return 1;
        return  jumpFloor2(target-1)*2;
    }
}
