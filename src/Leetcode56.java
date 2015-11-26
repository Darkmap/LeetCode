import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Qixuan on 2015/11/26.
 */
public class Leetcode56 {

    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if(size<=1)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                else
                    return o1.start - o2.start;
            }
        });

        List<Interval> res = new ArrayList<>();

        Interval last = intervals.get(0);
        for(int i=1;i<size;){
            Interval cur = intervals.get(i);
            if(last.end>=cur.start){
                if(last.end<cur.end){
                    last = new Interval(last.start, cur.end);
                }
                i++;
                if(i==size)
                    res.add(last);
            }
            else{
                res.add(last);
                last = cur;
                i++;
                if(i==size)
                    res.add(last);
            }
        }

        return res;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
