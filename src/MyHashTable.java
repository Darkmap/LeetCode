import java.util.HashSet;
import java.util.Set;

/**
 * This is the entry class of the HashTable,
 * which is organized as a linked list.
 * @param <K> key's class template sign
 * @param <V> value's class template sign
 */
class EntryNode<K,V>{

    K key;
    V value;
    EntryNode next,last;

    public EntryNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}

public class MyHashTable<K,V>{

    EntryNode<K,V>[] table;
    int capacity, size;
    //Usually 0.75, when greater than it, you should extend the table length.
    double loadFactor;

    public int hashCode(K key){
        return key.hashCode() % capacity;
    }

    public MyHashTable(){
        this(20);
    }
    public MyHashTable(int capacity){
        this.table = new EntryNode[capacity];
        this.capacity = capacity;
        this.loadFactor = 0.75;
    }

    public void put(K key, V value){
        int idx = hashCode(key);
        EntryNode<K,V> point = table[idx];
        if(point==null) {
            table[idx] = new EntryNode<>(key, value);
            this.size++;
        }
        else{
            //Find where is the entry in this LinkedList
            //Maybe we can use the LRU(Least Recently Used) strategy
            while(!point.key.equals(key) && point.next!=null){
                point = point.next;
            }
            if(point.key.equals(key)){
                //No new entry, so no need size++
                point.value = value;
            } else{
                point.next = new EntryNode<>(key,value);
                point.next.last = point;
                this.size++;
            }
        }
    }

    public V get(K key){
        int idx = hashCode(key);
        EntryNode<K,V> point = table[idx];
        if(point==null)
            return null;
        else{
            while(!point.key.equals(key) && point.next!=null){
                point = point.next;
            }
            if(point.key.equals(key)){
                return point.value;
            } else{
                return null;
            }
        }
    }

    public V remove(K key){
        int idx = hashCode(key);
        EntryNode<K,V> head = table[idx];
        if(head==null)
            return null;
        else{
            while(!head.key.equals(key) && head.next!=null){
                head = head.next;
            }
            if(head.key.equals(key)){
                //When you are removing the head, please be careful!
                if(head==table[idx]){
                    table[idx] = head.next;
                    table[idx].last = null;
                    return head.value;
                } else{
                    head.last.next = head.next;
                    //When you are removing the tail, please be careful!
                    if(head.next!=null)
                        head.next.last = head.last;
                    this.size--;
                    return head.value;
                }
            } else{
                return null;
            }
        }
    }

    public Set<K> keySet(){

        Set<K> res = new HashSet<>();

        for(EntryNode<K,V> head: table){
            while(head!=null){
                res.add(head.key);
                head = head.next;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        MyHashTable<String,Integer> map = new MyHashTable<>(10);

        map.put("a",1);
        map.put("b", 2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);
        map.put("f",6);

        Set<String> set = map.keySet();

        System.out.println(map.get("z"));
    }
}


