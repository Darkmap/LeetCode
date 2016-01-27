import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qixuanwang on 16/1/26.
 */
public class Leetcode295 {

    
}

class MedianFinder {

    PriorityQueue<Integer> larger = new PriorityQueue<>();
    PriorityQueue<Integer> smaller = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {

        larger.add(num);
        smaller.add(larger.poll());

        if(larger.size()<smaller.size())
            larger.add(smaller.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(smaller.size()==larger.size())
            return (smaller.peek()+larger.peek())*1.0/2;
        else
            return larger.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();