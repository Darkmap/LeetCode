/**
 * Created by qixuanwang on 15/8/28.
 */


public class Leetcode24 {

    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {

        if(head == null)
            return null;

        ListNode current = head;
        while(current!=null && current.next!=null){
            int tmp = current.val;
            current.val = current.next.val;
            current.next.val = tmp;
            current = current.next;
            if(current!=null){
                current = current.next;
            }
        }
        return head;
    }
}
