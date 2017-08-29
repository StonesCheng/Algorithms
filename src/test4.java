import java.util.Scanner;

/**
 * Created by RayCheng on 2017/8/28.
 */
public class test4 {
    public static class TreeNode {
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
        print(test);
    }
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private static  TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++)
        if(in[i]==pre[startPre]){
            root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
            root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
        }
        return root;
}
    public static void print(TreeNode test){
        if(test==null)
            System.out.println();
        else
            System.out.println(test.val);
        if (test.right != null)
            print(test.right);
        if (test.left != null)
            print(test.left);


    }
}
