import java.util.LinkedList;

/**
 * Created by Qixuan on 2015/12/10.
 */
public class APrepare {

    public static void main(String[] args) {

//        Cards deskCards = new Cards();
//        deskCards.shuffle();
//        deskCards.dropTop(1);
//        deskCards.print();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListManipulation.print(head);

        ListNode reHead = ListManipulation.reverseRe(head,null);
        ListManipulation.print(reHead);
    }

}

class ListManipulation{

    public static ListNode reverseIt(ListNode head){

        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static ListNode reverseRe(ListNode head, ListNode last){
        if(head==null)
            return head;


        if(head.next == null) {
            head.next = last;
            return head;
        }
        ListNode newHead = reverseRe(head.next, head);
        head.next = last;
        return newHead;
    }

    public static void print(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("------");
    }
}

class Cards{

    private LinkedList<Card> cardSet;

    public Cards(){
        cardSet = new LinkedList<>();
        for(int i=0;i<4;i++){
            for(int j=1;j<14;j++){

                char type = (char)('A'+i);
                cardSet.add(new Card(type+"", j));
            }
        }
    }

    public void dropTop(int number){

        LinkedList<Card> tmpCardSet = new LinkedList<>(this.cardSet);
        this.cardSet.clear();
        this.cardSet.addAll(tmpCardSet.subList(number,52));
        this.cardSet.addAll(tmpCardSet.subList(0,number));
    }

    public void shuffle(){

        LinkedList<Card> tmpCardSet = new LinkedList<>(this.cardSet);
        this.cardSet.clear();
        for(int i=51;i>=0;i--){
            int idx = (int)(Math.random()*i);
            this.cardSet.add(tmpCardSet.remove(idx));
        }
    }

    public void print(){
        for(Card thisCard: this.cardSet){
            System.out.println(thisCard.type+" "+thisCard.number);
        }
    }

}

class Card{
    String type;
    Integer number;

    public Card(){

    }

    public Card(String type, int number){
        this.type = new String(type);
        this.number = number;
    }
}