import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by qixuanwang on 16/6/27.
 */
public class Leetcode347 {

    public static void main(String[] args) {

        Leetcode347 lt = new Leetcode347();
        int[] nums = {1,1,1,1,2,2,2,3,3,4};
        List<Integer> res = lt.topKFrequent(nums, 2);

        for(int num: res){
            System.out.println(num);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, (map.containsKey(num)? map.get(num) : 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            pq.offer(new Pair(key, map.get(key)));
        }

        for(int i=0;i<k;i++){
            res.add(pq.poll().key);
        }
        return res;
    }
}

class Pair implements Comparable<Pair>{

    int key;
    int value;

    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int compareTo(Pair other){
        return other.value - value;
    }
}
