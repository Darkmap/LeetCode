import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qixuanwang on 16/1/25.
 */
public class Leetcode284 {


}

class PeekingIterator implements Iterator<Integer> {

    Queue<Integer> queue = new LinkedList<>();

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while(iterator.hasNext()){
            queue.offer(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}


class PeekingIterator2<T> implements Iterator<T> {

    Queue<T> queue = new LinkedList<>();

    public PeekingIterator2(Iterator<T> iterator) {
        // initialize any member here.
        while(iterator.hasNext()){
            queue.offer(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}