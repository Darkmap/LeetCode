import java.util.Arrays;

/**
 * Created by qixuanwang on 16/2/24.
 */
//Show the T should have the comparable feature
public class BinaryHeap<T extends Comparable>{

    T[] array;
    int capacity, size;

    public BinaryHeap () {
        this(20);
    }

    public BinaryHeap (T[] array) {
        this(array.length);
        this.array = Arrays.copyOf(array,array.length);
        this.size = array.length;
        heapify();
    }

    public BinaryHeap (int capacity){
        //Comparable is used to initialized this Array
        this.array = (T[])new Comparable[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(T value) {
        // Extend array if needed
        if (size >= array.length) {
            extendSize();
        }

        int index = size;
        array[index] = value;

        size++;

        siftUp(index);
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return array[0];
    }

    public T remove() {
        T result = peek();

        array[0] = array[size-1];
        array[size-1] = null;
        size--;

        siftDown(0);

        return result;
    }

    public void update(int idx, T value){
        array[idx] = value;
        siftDown(idx);
        siftUp(idx);
    }

    public void siftDown(int index) {

        if(hasLeftChild(index)) {

            int leftIdx = leftIndex(index);
            int minIdx = (array[leftIdx].compareTo(array[index])<0)? leftIdx:index;

            if (hasRightChild(index)) {
                int rightIdx = rightIndex(index);
                minIdx = (array[rightIdx].compareTo(array[minIdx])<0)? rightIdx:minIdx;
            }

            if (minIdx!=index) {
                swap(index, minIdx);
                siftDown(minIdx);
            }
        }
    }

    public void siftUp(int index) {
        if(index>0) {
            int parentIdx = parentIndex(index);
            if(array[parentIdx].compareTo(array[index]) > 0){
                swap(index, parentIdx);
                siftUp(parentIdx);
            }
        }
    }

    public void heapify(){
        int begin = parentIndex(size-1);
        for(int i=begin;i>=0;i--){
            siftDown(i);
        }
    }

    public int leftIndex(int i) {
        return i * 2 + 1;
    }

    public int rightIndex(int i) {
        return i * 2 + 2;
    }

    public boolean hasLeftChild(int i) {
        return leftIndex(i) < size;
    }

    public boolean hasRightChild(int i) {
        return rightIndex(i) < size;
    }

    public int parentIndex(int i) {
        return (i-1) / 2;
    }

    public void extendSize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    public void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


    public static void main(String[] args) {


        Integer[] array = new Integer[9];
        array[0] = 7;
        array[1] = 4;
        array[2] = 2;
        array[3] = 3;
        array[4] = 8;
        array[5] = 5;
        array[6] = 9;
        array[7] = 1;
        array[8] = 6;

        BinaryHeap<Integer> hp = new BinaryHeap<>(array);

        hp.update(3,11);

//        hp.insert(7);
//        hp.insert(4);
//        hp.insert(2);
//        hp.insert(3);
//        hp.insert(8);
//        hp.insert(5);
//        hp.insert(9);
//        hp.insert(1);
//        hp.insert(6);

        while(!hp.isEmpty()){
            System.out.println(hp.remove());
        }
    }
}

//public class BinaryHeap {
//
//    private int[] elements;
//    private int size;
//    private int capacity;
//
//    public BinaryHeap(int capacity) {
//        this.capacity = capacity;
//        this.size = 0;
//        this.elements = new int[capacity];
//    }
//
//    public BinaryHeap(int[] array){
//        this.elements = Arrays.copyOf(array, array.length);
//        this.size = array.length;
//        this.capacity = array.length;
//    }
//
//    public int parentIdx(int idx){
//        return (idx-1)/2;
//    }
//    public int leftChildIdx(int idx){
//        return idx*2+1;
//    }
//    public int rightChildIdx(int idx){
//        return idx*2+2;
//    }
//
//    public void buildMinHeap(){
//
//        int start = parentIdx(size-1);
//        for(int i=start;i>=0;i--){
//            this.minSiftDown(i);
//        }
//    }
//
//    public void minSiftUp(int idx){
//        if(idx!=0){
//            int parIdx = parentIdx(idx);
//            if(elements[parIdx]>elements[idx]){
//                int tmp = elements[parIdx];
//                elements[parIdx] = elements[idx];
//                elements[idx] = tmp;
//                minSiftUp(parIdx);
//            }
//        }
//    }
//
//    public void minSiftDown(int idx){
//        int leftIdx = leftChildIdx(idx);
//        int rightIdx = rightChildIdx(idx);
//
//        int newIdx = idx;
//
//        if(leftIdx<size){
//            if (elements[newIdx] > elements[leftIdx])
//                newIdx = leftIdx;
//        }
//
//        if(rightIdx<size){
//            if(elements[newIdx]>elements[rightIdx])
//                newIdx = rightIdx;
//        }
//
//        if(newIdx!=idx){
//            int tmp = elements[idx];
//            elements[idx] = elements[newIdx];
//            elements[newIdx] = tmp;
//            minSiftDown(newIdx);
//        }
//    }
//
//    public int remove(int idx){
//        int tmp = elements[idx];
//        elements[idx] = elements[size-1];
//        elements[size-1] = tmp;
//
//        this.size--;
//
//        minSiftDown(idx);
//        return tmp;
//    }
//
//    public int removeFirst(){
//        return remove(0);
//    }
//
//    public int getMin(){
//        return elements[0];
//    }
//
//    public void insert(int val){
//        elements[size] = val;
//        this.size++;
//        minSiftUp(size-1);
//    }
//
//    public List<Integer> nonDecreasingSort(){
//        List<Integer> res = new ArrayList<>(this.size);
//        while(size>0){
//            res.add(this.removeFirst());
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//
//
//        BinaryHeap heap = new BinaryHeap(10);
//        heap.insert(2);
//        heap.insert(3);
//        heap.insert(5);
//        heap.insert(1);
//        heap.insert(4);
//        heap.insert(7);
//        heap.insert(9);
//        heap.insert(10);
//        heap.insert(6);
//        heap.insert(8);
//        heap.buildMinHeap();
//
//        for(int num: heap.nonDecreasingSort())
//            System.out.println(num);
//    }
//}
