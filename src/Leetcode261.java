import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 * Created by qixuanwang on 16/2/26.
 */
public class Leetcode261 {


    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        Leetcode261 lt = new Leetcode261();
        System.out.println(lt.validTree(n,edges));
    }

    public boolean validTree(int n, int[][] edges) {

        List<HashSet<Integer>> maps = new ArrayList<>();
        for(int i=0;i<n;i++){
            maps.add(new HashSet<>());
        }

        for(int[] edge: edges){
            int n1 = edge[0];
            int n2 = edge[1];

            maps.get(n1).add(n2);
            maps.get(n2).add(n1);
        }

        HashSet<Integer> closed = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(closed.contains(cur))
                return false;
            for(int nbr: maps.get(cur)){
                if(closed.contains(nbr)){
                    return false;
                }else{
                    queue.add(nbr);
                    maps.get(nbr).remove(cur);
                }
            }

            closed.add(cur);
        }

        return closed.size()==n;
    }
}
