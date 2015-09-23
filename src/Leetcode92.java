/**
 * Created by qixuanwang on 15/9/21.
 */
public class Leetcode92 {

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        head.next = p1;
        ListNode p2 = new ListNode(3);
        p1.next = p2;

        reverseBetween(head,2,3);


    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if(m==n)
            return head;

        int len= n-m+1;
        ListNode[] listArray = new ListNode[len];

        ListNode cur = head;
        /**
         * 这里i=1开始,因为m是第m个元素,cur从head开始只要next m-1次即可.
         */
        for(int i=1;i<m;i++){
            cur = cur.next;
        }

        listArray[0] = cur;
        for(int i=1;i<len;i++){
            cur = cur.next;
            listArray[i] = cur;
        }

        int begin = 0, end = len-1;
        while(begin<end){
            int tmp = listArray[begin].val;
            listArray[begin].val = listArray[end].val;
            listArray[end].val = tmp;
            begin++;
            end--;
        }

        return head;
    }
}
