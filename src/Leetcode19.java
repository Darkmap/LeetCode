import java.util.ArrayList;

/**
 * Created by qixuanwang on 15/8/27.
 */

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}

public class Leetcode19 {

    public static void main(String[] args) {


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null){
            return null;
        }

        ArrayList<ListNode> nodeIdxTable = new ArrayList<ListNode>();
        ListNode itr = head;
        while(itr!=null){
            nodeIdxTable.add(itr);
            itr = itr.next;
        }


        int idx = nodeIdxTable.size()-n;

        //边界条件!!!
        if(idx==0)
            return head.next;

        ListNode last = nodeIdxTable.get(idx-1);

        ListNode next = null;

        //边界条件!!!
        if(n!=1)
            next = nodeIdxTable.get(idx+1);
        last.next = next;

        return head;

    }
}
