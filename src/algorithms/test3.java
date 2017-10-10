package algorithms;

import java.util.ArrayList;

/**
 * Created by RayCheng on 2017/8/25.
 */
public class test3 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
           this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        ArrayList<Integer> test=printListFromTailToHead(listNode);
        for (int i=0;i<test.size();i++)
            System.out.println(test.get(i));
    }
    public static ArrayList<Integer> temp=new ArrayList<Integer>();
    public  static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode!=null) {
            if (listNode.next != null) {
                printListFromTailToHead(listNode.next);
                temp.add(listNode.val);
            } else {
                temp.add(listNode.val);
            }
        }
        return temp;
    }
    /*public static void algorithms.test(ListNode listNode,ArrayList<Integer> temp){
        if(listNode==null)
            return ;
        if(listNode.next!=null){
            algorithms.test(listNode.next,temp);
            temp.add(listNode.val);
        }
        else {
            temp.add(listNode.val);
        }
    }*/
}