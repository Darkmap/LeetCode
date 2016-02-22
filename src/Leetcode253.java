import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qixuanwang on 16/2/20.
 */
public class Leetcode253 {

    public static void main(String[] args) {

        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(1,5);
        intervals[1] = new Interval(8,9);
        intervals[2] = new Interval(8,9);

        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int res = 0;
        int room = 0;

        for(int i=0;i<intervals.length;i++){
            Interval o = intervals[i];


            while(!heap.isEmpty()){
                int pend = heap.peek();
                if(pend>o.start){
                    room++;
                    res = Math.max(room,res);
                    heap.offer(o.end);
                    break;
                } else{
                    heap.poll();
                    room--;
                }
            }

            if(heap.isEmpty()){
                heap.offer(o.end);
                room++;
                res = Math.max(room,res);
            }

        }

        return res;
    }
}
