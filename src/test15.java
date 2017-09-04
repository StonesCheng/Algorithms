/**
 * Created by RayCheng on 2017/9/1.
 */
public class test15 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode test=new ListNode(1);
        test.next=new ListNode(2);
        test.next.next=new ListNode(3);
        test.next.next.next=new ListNode(4);
        test.next.next.next.next=new ListNode(5);
        test.next.next.next.next.next=new ListNode(6);
        test=ReverseList(test);
        for(int i=0;i<6;i++){
            System.out.println(test.val);
            test=test.next;
        }
    }
    public static ListNode ReverseList(ListNode head){
        if(head==null)
            return null;
        ListNode pre=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    /*public static ListNode ReverseList(ListNode head) {
        Stack<ListNode> temp=new Stack<>();
        if(head==null)
            return null;
        while (head!=null){
            temp.push(head);
            head=head.next;
        }
        ListNode first=temp.pop();
        ListNode test=temp.pop();
        first.next=test;
        while (!temp.isEmpty()){
            test.next=temp.pop();
            test=test.next;
        }
        return first;
    }*/
    /* static  Stack<ListNode> temp=new Stack<>();
    static  ListNode test=null;
    public static ListNode head1=null;
    public static ListNode ReverseList(ListNode head){
        ReverseList1(head);
        return head1;
    }
    public static void ReverseList1(ListNode head){
        if(head!=null)
            temp.push(head);
        if(head.next!=null)
            ReverseList(head.next);
        else {
            head1=temp.pop();
            test=temp.pop();
            head1.next=test;
        }
        if(!temp.isEmpty()) {
            test.next=temp.pop();
            test=test.next;
        }
    }*/
}
