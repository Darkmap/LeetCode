import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 16/3/1.
 */
public class Topological {

    public static void main(String[] args) {

        char[][] cons = {
                {'A','B'},
                {'A','C'},
                {'B','C'},
                {'B','D'},
                {'D','E'}
        };

        for(char c: topologicalSort(cons)){
            System.out.println(c);
        }
    }

    public static List<Character> topologicalSort(char[][] cons){

        List<Character> res = new ArrayList<>();

        if(cons==null || cons.length<=0)
            return res;

        HashMap<Character,Set<Character>> out = new HashMap<>();
        HashMap<Character,Integer> in = new HashMap<>();

        HashSet<Character> keys = new HashSet<>();

        for(int i=0;i<cons.length;i++){
            char n1 = cons[i][0];
            char n2 = cons[i][1];

            keys.add(n1);
            keys.add(n2);

            if(out.containsKey(n1)){
                out.get(n1).add(n2);
            } else{
                HashSet<Character> set = new HashSet<>();
                set.add(n2);
                out.put(n1,set);
            }

            if(in.containsKey(n2)) {
                in.put(n2,in.get(n2)+1);
            } else{
                in.put(n2,1);
            }
        }

        Stack<Character> top = new Stack<>();
        for(char c: keys){
            if(!in.containsKey(c)) {
                top.push(c);
            }
        }

        HashSet<Character> closed = new HashSet<>();

        while(!top.isEmpty()){

            char cur = top.pop();
            res.add(cur);
            closed.add(cur);

            if(out.containsKey(cur)) {
                for (char next : out.get(cur)) {

                    if (closed.contains(next)) {
                        return null;
                    }

                    int count = in.get(next);
                    count--;
                    if (count == 0) {
                        in.remove(next);
                        top.push(next);
                    } else {
                        in.put(next, count);
                    }
                }
            }
        }
        return res;
    }
}
