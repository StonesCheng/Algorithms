package algorithms;

import java.util.ArrayList;

/**
 * Created by RayCheng on 2017/9/1.
 */
public class test14 {
    public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
    }
    public static void main(String[] args) {

    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ArrayList<ListNode> temp=new ArrayList<>();
        ListNode test=head;
        if(test==null)
            return test;
        int flag=1;
        temp.add(test);
        while (test.next!=null){
            flag++;
            test=test.next;
            temp.add(test);
        }
        temp.add(test);
        if(k>flag|k==0){
            test=null;
            return test;
        }
        return temp.get(flag-k);
    }
    public ListNode FindKthToTail1(ListNode head,int k) {
        if(head==null|k<=0)
            return null;
        ListNode pre=head;
        ListNode last=head;
        for(int i=0;i<k;i++){
            if(pre.next!=null){
                pre=pre.next;
            }
            else
                return null;
        }
        while (pre.next!=null){
            pre=pre.next;
            last=last.next;
        }
        return last;
    }
}
