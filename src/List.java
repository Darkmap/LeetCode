/**
 * Created by qixuanwang on 15/8/21.
 */



public class List {

    public List nextNode;

    public String value;

    public List() {
        nextNode = null;
        value = "";
    }

    public void addNext(List next){
        nextNode = next;
    }

    public List(List nn, String val){
        nextNode = nn;
        value = val;
    }

    public void printList(){

        List itr = this;
        do{
            System.out.println(itr.value);
            itr = itr.nextNode;
        }while(itr!=null);
    }

    public static List reverseList(List last, List current){
        if(current.nextNode==null){
            current.nextNode = last;
            return current;
        }
        else{
            List next = current.nextNode;
            current.nextNode = last;
            return reverseList(current, next);
        }
    }

    public static void main(String[] args){
        List front = new List(null, "a");
        List n1 = new List(null, "b");
        List n2 = new List(null, "c");
        List n3 = new List(null, "d");
        List n4 = new List(null, "e");

        front.addNext(n1);
        n1.addNext(n2);
        n2.addNext(n3);
        n3.addNext(n4);


        front.printList();
        List newFont = List.reverseList(null, front);
        System.out.println("Reverse Done!");
        newFont.printList();

    }
}
