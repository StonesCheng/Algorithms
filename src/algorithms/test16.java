package algorithms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by RayCheng on 2017/9/4.
 */
public class test16 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) throws ParseException {
        //Date algorithms.test=new Date();
        SimpleDateFormat test=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=test.parse("2017-09-05 00:00:00");
        System.out.println();

    }
    /*public static ListNode algorithms.Merge(ListNode list1,ListNode list2) {
        ListNode head=null;
        ListNode current=null;
        if(list1==null&&list2==null) return null;
        if(list1==null&&list2!=null) return list2;
        if(list1!=null&&list2==null) return list1;
        if(list1.val>list2.val) {
            head = list2;
            current=list2.next;
        }
        else {
            head = list1;
            current=list1.next;
        }
        while(list1.next!=null|list2.next!=null){
            if(list1.next.val>list2.next.val){

            }
            else{

            }

        }
    }*/
}
