import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by qixuanwang on 16/3/1.
 */
/*
*	Let's define the graph as an n*n matrix G the G[i][j]
*	and G[j][i] are both equal to the weight of the edge
*	from i to j.
*	G[i][j]==-1 means there is no such edge from i to j.
*	G[i][i] will be 0.
*/
class Node implements Comparable<Node>{

    int index;
    int cost;

    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other){
        return this.cost - other.cost;
    }

    //Need this equals to implement the remove() operation of PriorityQueue
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node))
            return false;
        if (obj == this)
            return true;

        Node node = (Node) obj;
        return this.index == node.index;
    }
}

public class Dijkstras {

    /**
     * Solve the Dijkstra's problem
     * @param graph The graph matrix
     * @param start The start point
     */
    public static void solve(int[][] graph, int start){

        if(graph==null)
            return;
        int n = graph.length;
        if(n==0)
            return;

        //Open list
        PriorityQueue<Node> queue = new PriorityQueue<>();
        //Hash index for the use of update the value in the PriorityQueue
        HashMap<Integer, Node> map = new HashMap<>();
        //Closed list: store have been processed node's index
        HashSet<Integer> closed = new HashSet<>();

        closed.add(start);
        map.put(start,new Node(start,0));

        for(int i=0;i<n;i++){
            if(i!=start){
                Node cur = new Node(i,graph[start][i]);
                queue.offer(cur);
                map.put(i,cur);
            }
        }

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.cost>=Integer.MAX_VALUE)
                break;

            for(int i=0;i<n;i++){
                //Deal with the node not in the closed and accessible node
                if(!closed.contains(i) && i!=cur.index && graph[cur.index][i]<Integer.MAX_VALUE){
                    int newCost = cur.cost + graph[cur.index][i];
                    Node neighbor = map.get(i);
                    //If the cost from cur node is smaller, then update it.
                    if(neighbor.cost > newCost){
                        queue.remove(neighbor);
                        neighbor.cost = newCost;
                        queue.offer(neighbor);
                    }
                }
            }
            closed.add(cur.index);
        }

        for(int idx: closed){
            Node node = map.get(idx);
            System.out.println(node.index + "\t" + node.cost);
        }
    }


    public static void main(String[] args) {

        final int MAX = Integer.MAX_VALUE;

        int[][] graph = {
                {0,2,3,MAX,MAX,MAX},
                {2,0,MAX,1,MAX,MAX},
                {3,MAX,0,2,4,MAX},
                {MAX,1,2,0,6,7},
                {MAX,MAX,4,6,0,8},
                {MAX,MAX,MAX,7,8,0}
        };

        solve(graph,0);
    }
}














