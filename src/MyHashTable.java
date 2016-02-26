import java.util.HashSet;
import java.util.Set;

class EntryNode<K,V>{

    K key;
    V value;

    EntryNode last;
    EntryNode next;

    public EntryNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}

public class MyHashTable<K,V>{

    EntryNode<K,V>[] table;

    int capacity;
    double loadFactor;
    int size;

    public int hash(K key){
        return key.hashCode() % capacity;
    }

    public MyHashTable(){
        this.table = new EntryNode[20];
        this.capacity = 20;
        this.loadFactor = 0.8;
    }

    public MyHashTable(int capacity){
        this.table = new EntryNode[capacity];
        this.capacity = capacity;
        this.loadFactor = 0.8;
    }

    public void put(K key, V value){
        int idx = hash(key);
        EntryNode<K,V> head = table[idx];
        if(head==null)
            table[idx] = new EntryNode<>(key,value);
        else{
            while(!head.key.equals(key) && head.next!=null){
                head = head.next;
                this.size++;
            }
            if(head.key.equals(key)){
                head.value = value;
            } else{
                head.next = new EntryNode<>(key,value);
                this.size++;
            }
        }
    }

    public V get(K key){
        int idx = hash(key);
        EntryNode<K,V> head = table[idx];
        if(head==null)
            return null;
        else{
            while(!head.key.equals(key) && head.next!=null){
                head = head.next;
            }
            if(head.key.equals(key)){
                return head.value;
            } else{
                return null;
            }
        }
    }

    public V remove(K key){
        int idx = hash(key);
        EntryNode<K,V> head = table[idx];
        if(head==null)
            return null;
        else{
            while(!head.key.equals(key) && head.next!=null){
                head = head.next;
            }
            if(head.key.equals(key)){
                head.last.next = head.next;
                head.last = null;
                head.next = null;
                this.size--;
                return head.value;
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


    //TODO hashCode()

}


