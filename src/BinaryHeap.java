import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qixuanwang on 16/2/24.
 */
public class BinaryHeap {

    private int[] elements;
    private int size;
    private int capacity;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.elements = new int[capacity];
    }

    public BinaryHeap(int[] array){
        this.elements = Arrays.copyOf(array, array.length);
        this.size = array.length;
        this.capacity = array.length;
    }

    public int parentIdx(int idx){
        return (idx-1)/2;
    }
    public int leftChildIdx(int idx){
        return idx*2+1;
    }
    public int rightChildIdx(int idx){
        return idx*2+2;
    }

    public void buildMinHeap(){

        int start = parentIdx(size-1);
        for(int i=start;i>=0;i--){
            this.minSiftDown(i);
        }
    }

    public void minSiftUp(int idx){
        if(idx!=0){
            int parIdx = parentIdx(idx);
            if(elements[parIdx]>elements[idx]){
                int tmp = elements[parIdx];
                elements[parIdx] = elements[idx];
                elements[idx] = tmp;
                minSiftUp(parIdx);
            }
        }
    }

    public void minSiftDown(int idx){
        int leftIdx = leftChildIdx(idx);
        int rightIdx = rightChildIdx(idx);

        int newIdx = idx;

        if(leftIdx<size){
            if (elements[newIdx] > elements[leftIdx])
                newIdx = leftIdx;
        }

        if(rightIdx<size){
            if(elements[newIdx]>elements[rightIdx])
                newIdx = rightIdx;
        }

        if(newIdx!=idx){
            int tmp = elements[idx];
            elements[idx] = elements[newIdx];
            elements[newIdx] = tmp;
            minSiftDown(newIdx);
        }
    }

    public int remove(int idx){
        int tmp = elements[idx];
        elements[idx] = elements[size-1];
        elements[size-1] = tmp;

        this.size--;

        minSiftDown(idx);
        return tmp;
    }

    public int removeFirst(){
        return remove(0);
    }

    public int getMin(){
        return elements[0];
    }

    public void insert(int val){
        elements[size] = val;
        this.size++;
        minSiftUp(size-1);
    }

    public List<Integer> nonDecreasingSort(){
        List<Integer> res = new ArrayList<>(this.size);
        while(size>0){
            res.add(this.removeFirst());
        }
        return res;
    }

    public static void main(String[] args) {


        BinaryHeap heap = new BinaryHeap(10);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(1);
        heap.insert(4);
        heap.insert(7);
        heap.insert(9);
        heap.insert(10);
        heap.insert(6);
        heap.insert(8);
        heap.buildMinHeap();

        for(int num: heap.nonDecreasingSort())
            System.out.println(num);
    }
}
