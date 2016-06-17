import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 16/6/14.
 */
public class Leetcode332 {

    static boolean found = false;

    public static List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        res.add("JFK");
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] pair: tickets){
            if(map.containsKey(pair[0])){
                map.get(pair[0]).add(pair[1]);
            } else{
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(pair[1]);
                map.put(pair[0], pq);
            }
        }

        helper(tickets.length+1, res, map);

        return res;
    }

    public static boolean helper(int len, List<String> res, HashMap<String, PriorityQueue<String>> map){
        if(found)
            return true;
        if(res.size() == len && map.isEmpty()){
            found = true;
            return true;
        }
        String head = res.get(res.size()-1);
        PriorityQueue<String> realPQ = map.get(head);
        if(map.containsKey(head)){
            ArrayList<String> list = new ArrayList<>(realPQ);
            Collections.sort(list);
            for(String end: list){
                realPQ.remove(end);
                if(realPQ.isEmpty()){
                    map.remove(head);
                }
                res.add(end);
                if(helper(len, res, map)){
                    return true;
                }
                realPQ.add(end);
                if(!map.containsKey(head))
                    map.put(head, realPQ);
            }
        }
        res.remove(res.size()-1);
        return false;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"AXA","EZE"},{"EZE","AUA"},{"ADL","JFK"},{"ADL","TIA"},{"AUA","AXA"},{"EZE","TIA"},{"EZE","TIA"},{"AXA","EZE"},{"EZE","ADL"},{"ANU","EZE"},{"TIA","EZE"},{"JFK","ADL"},{"AUA","JFK"},{"JFK","EZE"},{"EZE","ANU"},{"ADL","AUA"},{"ANU","AXA"},{"AXA","ADL"},{"AUA","JFK"},{"EZE","ADL"},{"ANU","TIA"},{"AUA","JFK"},{"TIA","JFK"},{"EZE","AUA"},{"AXA","EZE"},{"AUA","ANU"},{"ADL","AXA"},{"EZE","ADL"},{"AUA","ANU"},{"AXA","EZE"},{"TIA","AUA"},{"AXA","EZE"},{"AUA","SYD"},{"ADL","JFK"},{"EZE","AUA"},{"ADL","ANU"},{"AUA","TIA"},{"ADL","EZE"},{"TIA","JFK"},{"AXA","ANU"},{"JFK","AXA"},{"JFK","ADL"},{"ADL","EZE"},{"AXA","TIA"},{"JFK","AUA"},{"ADL","EZE"},{"JFK","ADL"},{"ADL","AXA"},{"TIA","AUA"},{"AXA","JFK"},{"ADL","AUA"},{"TIA","JFK"},{"JFK","ADL"},{"JFK","ADL"},{"ANU","AXA"},{"TIA","AXA"},{"EZE","JFK"},{"EZE","AXA"},{"ADL","TIA"},{"JFK","AUA"},{"TIA","EZE"},{"EZE","ADL"},{"JFK","ANU"},{"TIA","AUA"},{"EZE","ADL"},{"ADL","JFK"},{"ANU","AXA"},{"AUA","AXA"},{"ANU","EZE"},{"ADL","AXA"},{"ANU","AXA"},{"TIA","ADL"},{"JFK","ADL"},{"JFK","TIA"},{"AUA","ADL"},{"AUA","TIA"},{"TIA","JFK"},{"EZE","JFK"},{"AUA","ADL"},{"ADL","AUA"},{"EZE","ANU"},{"ADL","ANU"},{"AUA","AXA"},{"AXA","TIA"},{"AXA","TIA"},{"ADL","AXA"},{"EZE","AXA"},{"AXA","JFK"},{"JFK","AUA"},{"ANU","ADL"},{"AXA","TIA"},{"ANU","AUA"},{"JFK","EZE"},{"AXA","ADL"},{"TIA","EZE"},{"JFK","AXA"},{"AXA","ADL"},{"EZE","AUA"},{"AXA","ANU"},{"ADL","EZE"},{"AUA","EZE"}};
//        String[][] tickets = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
//        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(findItinerary(tickets));
    }
}
