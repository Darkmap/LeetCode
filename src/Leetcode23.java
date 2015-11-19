import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qixuanwang on 15/11/19.
 */
public class Leetcode23 {

    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for(ListNode list: lists){
            if(list!=null)
                minHeap.offer(list);
        }

        while(!minHeap.isEmpty()){

            ListNode temp = minHeap.poll();
            cur.next = temp;
            if(temp.next!=null)
                minHeap.offer(temp.next);
            cur = cur.next;
        }

        return dummy.next;
    }






    /**
     * 该方法TLE,放弃
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;

        if(len==0)
            return null;

        while(len>1){
            lists[0] = mergeTwo2(lists, 0, len-1);
            len--;
        }

        return lists[0];
    }

    public static ListNode mergeTwo2(ListNode[] lists, int head, int tail){

        ListNode newList = new ListNode(0);
        ListNode res = newList;

        ListNode l1 = lists[head];
        ListNode l2 = lists[tail];

        if(l1==null){
            newList = l2;
        }
        else if(l2==null){
            newList = l1;
        }
        else{
            while(l1!=null || l2!=null){
                if(l1==null){
                    newList.next = l2;
                    break;
                }
                else if(l2==null){
                    newList.next = l1;
                    break;
                }
                else{
                    if(l1.val<l2.val){
                        newList.next = l1;
                        l1 = l1.next;
                        newList = newList.next;
                    }
                    else{
                        newList.next = l2;
                        l2 = l2.next;
                        newList = newList.next;
                    }
                }
            }
        }

        return res.next;
    }

}
