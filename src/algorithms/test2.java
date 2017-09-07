package algorithms;

/**
 * Created by RayCheng on 2017/8/25.
 */
public class test2 {
    public static void main(String[] args) {
        StringBuffer test=new StringBuffer("Hello World");
        System.out.println(replaceSpace(test));
    }
    public static String replaceSpace(StringBuffer str){
        char[] temp=str.toString().toCharArray();
        StringBuffer buffer=new StringBuffer();
        for (int i=0;i<temp.length;i++){
            if(temp[i]==' ')
                buffer.append("%20");
            else
                buffer.append(temp[i]);
        }
        return buffer.toString();
    }
}
