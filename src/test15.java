import java.util.Stack;

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
        test=ReverseList(test);
        for(int i=0;i<5;i++){
            System.out.println(test.val);
            test=test.next;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        Stack<ListNode> temp=new Stack<>();
        if(head==null)
            return null;
        while (head.next!=null){
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
    }
}
