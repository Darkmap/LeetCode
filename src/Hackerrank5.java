import java.util.*;

/**
 * Created by qixuanwang on 16/1/29.
 */
public class Hackerrank5 {


    /*public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());

        HashMap<Integer,Integer> counts = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> sub = new HashMap<>();
        HashSet<Integer> child = new HashSet<>();

        int idx = 1;

        for(int time=0;time<n;time++){
            String[] tokens = in.nextLine().split(" ");
            if(tokens[0].equals("A")){
                map.put(idx,new HashSet<>());
                counts.put(idx,Integer.valueOf(tokens[1]));
                idx++;
            }
            else if(tokens[0].equals("B")){
                int x = Integer.valueOf(tokens[1]);
                int y = Integer.valueOf(tokens[2]);

                if(!child.contains(x) && !child.contains(y)){
                    if(sub.containsKey(x) && sub.containsKey(y)){
                        for(int i: sub.get(x)){
                            for(int j: sub.get(y)){
                                map.get(i).add(j);
                                map.get(j).add(i);
                            }
                        }
                    }
                    else if(sub.containsKey(x)){
                        for(int i: sub.get(x)){
                            map.get(i).add(y);
                            map.get(y).add(i);
                        }
                    }
                    else if(sub.containsKey(y)){
                        for(int i: sub.get(y)){
                            map.get(i).add(x);
                            map.get(x).add(i);
                        }
                    }
                    else{
                        map.get(y).add(x);
                        map.get(x).add(y);
                    }
                }
            }
            else{
                int x = Integer.valueOf(tokens[1]);

                sub.put(idx, new HashSet<>());
                if(!child.contains(x)){

                    HashSet<Integer> closed = new HashSet<>();
                    closed.add(x);
                    if(sub.containsKey(x)){
                        for(int j: sub.get(x)){
                            merge(idx, j, map, sub, closed, child);
                        }
                    }
                    else{
                        merge(idx, x, map, sub, closed, child);
                    }
                }
                idx++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i: counts.keySet()){
            HashSet<Integer> closed = new HashSet<>();
            closed.add(i);
            dfs(false, 0, i, res, closed, counts, map);
        }


        System.out.println(Collections.max(res));

    }

    public static void merge(int idx, int node, HashMap<Integer,HashSet<Integer>> map,
                             HashMap<Integer,HashSet<Integer>> sub, HashSet<Integer> closed,
                             HashSet<Integer> child){

        sub.get(idx).add(node);
        child.add(node);

        for(int next: map.get(node)) {
            if(!closed.contains(next)){
                closed.add(next);
                merge(idx, next, map, sub, closed, child);
            }
        }
    }
    public static void dfs(boolean flag, int pre, int node, ArrayList<Integer> res, HashSet<Integer> closed, HashMap<Integer,Integer> counts,
                           HashMap<Integer, HashSet<Integer>> map){
        ArrayList<Integer> open = new ArrayList<>();
        for(int next: map.get(node)){
            if(!closed.contains(next))
                open.add(next);
        }
        if(open.size()==0){
            if(flag)
                res.add(pre+counts.get(node));
            else
                res.add(pre);
            return;
        }

        for(int next: open){

            HashSet<Integer> newClosed = new HashSet<>(closed);
            newClosed.add(next);
            if (flag) {
                dfs(false, pre + counts.get(node), next, res, newClosed, counts, map);
                dfs(true, pre, next, res, newClosed, counts, map);
            }
            else{
                dfs(true, pre, next, res, newClosed, counts, map);
            }
        }

    }*/

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());

        HashMap<Integer,Integer> counts = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> sub = new HashMap<>();
        HashSet<Integer> child = new HashSet<>();

        int idx = 1;

        for(int time=0;time<n;time++){
            String[] tokens = in.nextLine().split(" ");
            if(tokens[0].equals("A")){
                map.put(idx,new HashSet<>());
                counts.put(idx,Integer.valueOf(tokens[1]));
                idx++;
            }
            else if(tokens[0].equals("B")){
                int x = Integer.valueOf(tokens[1]);
                int y = Integer.valueOf(tokens[2]);

                if(!child.contains(x) && !child.contains(y)){
                    if(sub.containsKey(x) && sub.containsKey(y)){
                        for(int i: sub.get(x)){
                            for(int j: sub.get(y)){
                                map.get(i).add(j);
                                map.get(j).add(i);
                            }
                        }
                    }
                    else if(sub.containsKey(x)){
                        for(int i: sub.get(x)){
                            map.get(i).add(y);
                            map.get(y).add(i);
                        }
                    }
                    else if(sub.containsKey(y)){
                        for(int i: sub.get(y)){
                            map.get(i).add(x);
                            map.get(x).add(i);
                        }
                    }
                    else{
                        map.get(y).add(x);
                        map.get(x).add(y);
                    }
                }
            }
            else{
                int x = Integer.valueOf(tokens[1]);

                if(!child.contains(x)){

                    sub.put(idx, new HashSet<>());

                    HashSet<Integer> closed = new HashSet<>();
                    closed.add(x);

                    if(sub.containsKey(x)){
                        child.add(x);
                        for(int j: sub.get(x)){
                            merge(idx, j, map, sub, closed, child);
                        }
                    }
                    else{
                        merge(idx, x, map, sub, closed, child);
                    }
                    idx++;
                }
            }
        }

//        ArrayList<Integer> res = new ArrayList<>();
//        for(int i: counts.keySet()){
//            HashSet<Integer> closed = new HashSet<>();
//            HashSet<Integer> added = new HashSet<>();
//            closed.add(i);
//            dfs(0, i, res, closed, added, counts, map);
//        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i: counts.keySet()){
            HashSet<Integer> closed = new HashSet<>();
            HashSet<Integer> added = new HashSet<>();
            closed.add(i);
            added.add(i);
            added.addAll(map.get(i));
            for(int next: map.get(i)){
                dfs(counts.get(i), next, res, closed, added, counts, map);
            }
        }


        System.out.println(Collections.max(res));
    }

    public static void merge(int idx, int node, HashMap<Integer,HashSet<Integer>> map,
                             HashMap<Integer,HashSet<Integer>> sub, HashSet<Integer> closed,
                             HashSet<Integer> child){
        sub.get(idx).add(node);
        child.add(node);

        for(int next: map.get(node)) {
            if(!closed.contains(next)){
                closed.add(next);
                merge(idx, next, map, sub, closed, child);
            }
        }
    }

    public static void dfs(int pre, int node, ArrayList<Integer> res, HashSet<Integer> closed,
                           HashSet<Integer> added, HashMap<Integer,Integer> counts,
                           HashMap<Integer,HashSet<Integer>> map){


        HashSet<Integer> newAdded = new HashSet<>(added);

        ArrayList<Integer> open = new ArrayList<>();

        for(int next: map.get(node)){
            if(!closed.contains(next)) {
                open.add(next);
            }
            newAdded.add(next);
        }

        if(open.size()==0){
            if(!added.contains(node))
                res.add(pre+counts.get(node));
            else
                res.add(pre);
            return;
        }



        for(int next: open){

            HashSet<Integer> newClosed = new HashSet<>(closed);
            newClosed.add(next);

            if (!added.contains(node)) {
                dfs(pre + counts.get(node), next, res, newClosed, newAdded, counts, map);
            }

            dfs(pre, next, res, newClosed, added, counts, map);
        }

    }



}
