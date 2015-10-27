/**
 * Created by qixuanwang on 15/10/22.
 */
public class Leetcode143 {

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(4);

        merge(head, head2);
    }

    public static void reorderList(ListNode head) {

        if(head==null)
            return;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = reverse(slow.next);
        slow.next = null;
        //merge(head, l2);

    }

    public static void merge(ListNode h1, ListNode h2){

        if(h1==null || h2==null)
            return;

        ListNode p1 = h1;
        ListNode p2 = h2;
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        while(p1!=null && p2!=null){
            tmp1 = p1.next;
            tmp2 = p2.next;
            p1.next = p2;
            p2.next = tmp1;
            p1 = tmp1;
            p2 = tmp2;
        }
    }

    public static ListNode reverse(ListNode head){

        if(head==null || head.next==null)
            return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(next!=null){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;

        return cur;
    }
}
