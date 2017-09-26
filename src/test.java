/**
 * Created by RayCheng on 2017/9/12.
 */
public class test {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode list1=new ListNode(1);
        ListNode list2=new ListNode(2);
        list1.next=new ListNode(3);
        list1.next.next=new ListNode(5);
        list2.next=new ListNode(4);
        list2.next.next=new ListNode(6);
        ListNode test= Merge(list1,list2);
        printf(test);
    }
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val<=list2.val){
            list1.next=Merge(list1.next,list2);
            return list1;
        }else {
            list2.next=Merge(list1,list2.next);
            return list2;
        }
    }
    public static void printf(ListNode in){
        System.out.println(in.val);
        if(in.next!=null)
            printf(in.next);
    }
}
