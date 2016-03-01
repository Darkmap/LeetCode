import java.util.HashMap;

/**
 * Created by qixuanwang on 16/2/29.
 */
class Block{
    private int key;
    private int value;

    Block pre;
    Block next;

    public Block(){

    }
    public Block(int key, int value){
        this.key = key;
        this.value = value;
    }
    public void setKey(int key){
        this.key = key;
    }
    public int getKey(){
        return key;
    }
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}

public class LRUCache {

    private int capacity;

    private Block head;
    private Block tail;

    private int size;

    private HashMap<Integer,Block> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer,Block>();
    }

    public int get(int key) {

        if(map.containsKey(key)){
            Block rm = map.get(key);

            //Don't forget this check
            if(head==rm){
                return rm.getValue();
            }
            else{
                //Don't forget this check
                if(rm==tail){
                    tail = tail.pre;
                }

                rm.pre.next = rm.next;
                if(rm.next!=null)
                    rm.next.pre = rm.pre;

                head.pre = rm;
                rm.next = head;
                rm.pre = null;
                head = rm;

                return rm.getValue();
            }
        } else{
            return -1;
        }
    }

    public void set(int key, int value) {

        if(map.containsKey(key)){
            Block rm = map.get(key);

            //Don't forget this check
            if(head==rm){
                rm.setValue(value);
            } else{
                //Don't forget this check
                if(rm==tail){
                    tail = tail.pre;
                }

                rm.pre.next = rm.next;
                if(rm.next!=null)
                    rm.next.pre = rm.pre;

                head.pre = rm;
                rm.next = head;
                rm.pre = null;
                head = rm;

                rm.setValue(value);
            }

        } else{

            Block insert = new Block(key,value);
            map.put(key,insert);

            if(size<capacity){
                size++;
                if(head==null){
                    head = insert;
                    tail = insert;
                } else{
                    head.pre = insert;
                    insert.next = head;
                    head = insert;
                }
            } else{
                head.pre = insert;
                insert.next = head;
                head = insert;
                //Don't forget this step, because otherwise the map will still keep this Block.
                map.remove(tail.getKey());
                tail = tail.pre;
                tail.next = null;
            }
        }
    }

    public static void main(String[] args) {

        LRUCache lr = new LRUCache(2);
        lr.set(2,1);
        lr.set(1,1);
        System.out.println(lr.get(2));
        lr.set(4, 1);
        System.out.println(lr.get(1));
        System.out.println(lr.get(2));
    }
}
