/**
 * Created by qixuanwang on 15/9/29.
 */
public class Leetcode109 {


    public static void main(String[] args) {


        ListNode head = new ListNode(-1);
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(2);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = null;

        sortedListToBST(head);

        System.out.println();

    }

    public static TreeNode sortedListToBST(ListNode head) {

        if(head==null)
            return null;


        int mid = 0;
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;
            mid++;
        }

        TreeNode root = new TreeNode(slow.val);

        root.left = bstHelper(head, mid);

        if(fast==null)
            root.right = bstHelper(slow.next,mid-1);
        else
            root.right = bstHelper(slow.next, mid);

        return root;
    }

    public static TreeNode bstHelper(ListNode head, int len){

        if(len<=0)
            return null;

        int mid = (len-1)/2;
        ListNode cur = head;
        for(int i=0;i<mid;i++){
            cur = cur.next;
        }

        TreeNode curRoot = new TreeNode(cur.val);

        curRoot.left = bstHelper(head, mid);
        curRoot.right = bstHelper(cur.next, len-mid-1);

        return curRoot;
    }
    
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}