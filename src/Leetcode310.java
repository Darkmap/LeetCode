import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 16/1/27.
 */
public class Leetcode310 {
    public static void main(String[] args) {

        int[][] edges = {{1,0}};

        for(int i: findMinHeightTrees3(2, edges)){
            System.out.println(i);
        }
    }

    public static List<Integer> findMinHeightTrees3(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            map.get(i).add(j);
            map.get(j).add(i);
        }


        List<Integer> leaves = new ArrayList<>();

        int count = n;
        while(count>2){
            for(int node: map.keySet()){
                if(map.get(node).size()==1)
                    leaves.add(node);
            }
            count -= leaves.size();
            for(int node: leaves){
                for(int neighbor: map.get(node)){
                    map.get(neighbor).remove(node);
                }
                map.remove(node);
            }
        }

        return new ArrayList<>(map.keySet());
    }


    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] edge: edges){
            int i = edge[0];
            int j = edge[1];
            map.get(i).add(j);
            map.get(j).add(i);
        }
        int minDepth = Integer.MAX_VALUE;
        int[] roots = new int[n];
        for(int i=0;i<n;i++){
            roots[i] = bfs(minDepth,i,map);
            minDepth = Math.min(minDepth,roots[i]);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(roots[i]==minDepth)
                res.add(i);
        }
        return res;
    }

    public static int bfs(int minDepth, int root, HashMap<Integer,ArrayList<Integer>> map){

        Queue<Integer> open = new LinkedList<>();
        open.add(root);
        Set<Integer> closed = new HashSet<>();
        int curDepth = 0;

        while(!open.isEmpty()){
            int count = open.size();
            for(int i=0;i<count;i++){
                int cur = open.poll();
                for(int child: map.get(cur)){
                    if(!closed.contains(child))
                        open.offer(child);
                }
                closed.add(cur);
            }
            curDepth++;
            if(curDepth>minDepth){
                return curDepth;
            }
        }
        return curDepth;
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] dis = new int[n][n];


        for(int i=0;i<n;i++){
            Arrays.fill(dis[i], -1);
            dis[i][i] = 0;
        }

        for(int[] edge: edges){
            int i = edge[0];
            int j = edge[1];

            for(int x=0;x<n;x++){
                if(dis[i][x]>0){
                    if(dis[j][x]>0)
                        dis[j][x] = dis[x][j] = Math.min(dis[j][x],dis[i][x]+1);
                    else
                        dis[j][x] = dis[x][j] = dis[i][x]+1;
                }
                if(dis[j][x]>0){
                    if(dis[i][x]>0)
                        dis[i][x] = dis[x][i] = Math.min(dis[i][x],dis[j][x]+1);
                    else
                        dis[i][x] = dis[x][i] = dis[j][x]+1;
                }
            }
            dis[i][j] = dis[j][i] = 1;
        }

        List<Integer> res = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int[] roots = new int[n];
        for(int i=0;i<n;i++){
            int max = dis[i][0];
            for(int count: dis[i])
                max = Math.max(max,count);
            roots[i] = max;
            min = Math.min(min,max);
        }

        for(int i=0;i<n;i++){
            if(roots[i]==min)
                res.add(i);
        }
        return res;
    }
}
