import java.util.Scanner;

/**
 * Created by RayCheng on 2017/8/28.
 */
public class test4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] a,b ;
        int[] pre,in;
        a = scanner.nextLine().split(",");
        pre=new int[a.length];
        for(int i=0;i<a.length;i++)
            pre[i]=Integer.valueOf(a[i]).intValue();
        b = scanner.nextLine().split(",");
        in=new int[b.length];
        for(int i=0;i<b.length;i++)
            in[i]=Integer.valueOf(b[i]).intValue();
        TreeNode test=reConstructBinaryTree(pre,in);
    }
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {

    }
}
