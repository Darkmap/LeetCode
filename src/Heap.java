/**
 * Created by qixuanwang on 15/8/22.
 */

public class Heap {

    private int[] heapArray;
    private int heapSize;
    private int heapLength;

    public int getParentIdx(int idx){
        return (idx-1)/2;
    }

    public int getLeftIdx(int idx){
        return 2*idx+1;
    }

    public int getRightIdx(int idx){
        return 2*idx+2;
    }

    public int[] getHeapArray() {
        return heapArray;
    }

    public void setValue(int idx, int val){
        heapArray[idx] = val;
    }

    public int getValue(int idx){
        return heapArray[idx];
    }

    //*************Auto Generated********************
    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public int getHeapLength() {
        return heapLength;
    }

    public void setHeapLength(int heapLength) {
        this.heapLength = heapLength;
    }
    //***********************************************

    public Heap(int length) {
        this.heapArray = new int[length];
        this.setHeapSize(0);
        this.setHeapLength(length);
    }

    public Heap(int[] array){
        this.heapArray = new int[array.length];
        this.setHeapSize(array.length);
        this.setHeapLength(array.length);
        System.arraycopy(array, 0, this.heapArray, 0, array.length);
    }

    public Heap(Heap srcone) {
        this.heapArray = new int[srcone.getHeapLength()];
        System.arraycopy(srcone.getHeapArray(), 0, this.heapArray, 0, srcone.getHeapSize());
        this.setHeapSize(srcone.getHeapSize());
        this.setHeapLength(srcone.getHeapLength());
    }

    public void print(){
        for(int i=0;i<this.heapSize;i++){
            System.out.print(this.getValue(i) + "\t");
        }
        System.out.println();
    }

    public static void buildMaxHeap(Heap curHeap){

        int startIdx = (curHeap.getHeapSize()-1)/2;
        for(int i=startIdx;i>=0;i--){
            maxHeapify(curHeap, i);
        }

    }

    public static void maxHeapify(Heap curHeap, int idx){
        int left = curHeap.getLeftIdx(idx);
        int right = curHeap.getRightIdx(idx);
        int largest = idx;
        if(left<curHeap.getHeapSize() && curHeap.getValue(left)> curHeap.getValue(idx)){
            largest = left;
        }
        if(right<curHeap.getHeapSize() && curHeap.getValue(right)> curHeap.getValue(largest)){
            largest = right;
        }
        if(largest!=idx){
            int temp = curHeap.getValue(idx);
            curHeap.setValue(idx,curHeap.getValue(largest));
            curHeap.setValue(largest,temp);
            maxHeapify(curHeap, largest);
        }
    }

    public static void ascendingSort(Heap curHeap){

        int orgSize = curHeap.getHeapSize();
        buildMaxHeap(curHeap);
        for(int i= orgSize-1;i>0;i--){
            int temp = curHeap.getValue(i);
            curHeap.setValue(i, curHeap.getValue(0));
            curHeap.setValue(0,temp);
            curHeap.setHeapSize(curHeap.getHeapSize() - 1);
            maxHeapify(curHeap, 0);
        }
        curHeap.setHeapSize(orgSize);
    }

    public static void main(String[] args){

        int[] array = new int[] {9,4,5,3,6,8,7,2,1,0};
        Heap testHeap = new Heap(array);
//        Random random = new Random();
//        for(int i=0;i<10;i++){
//            testHeap.setValue(i, Math.abs(random.nextInt() % 30));
//            testHeap.setHeapSize(testHeap.getHeapSize() + 1);
//        }
        testHeap.print();

        buildMaxHeap(testHeap);

        testHeap.print();

        ascendingSort(testHeap);




        testHeap.print();

    }

}
