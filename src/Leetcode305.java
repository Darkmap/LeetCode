import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 16/3/5.
 */
public class Leetcode305 {


    public static void main(String[] args) {

        Leetcode305 lt = new Leetcode305();
        int[][] positions = {
                {0,1},
                {1,2},
                {2,1},
                {1,0},
                {0,2},
                {0,0},
                {1,1}
        };

        for(int num: lt.numIslands2(3,3,positions)){
            System.out.println(num);
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> res = new ArrayList<>();

        Land[] nodes = new Land[m*n];

        int num = 0;

        for(int[] point: positions){
            int x = point[0];
            int y = point[1];

            num++;

//            System.out.println(x+","+y);

            nodes[x*n+y] = new Land(x,y);

            if(isLand(x-1,y,nodes,m,n)){
                Land near = nodes[(x-1)*n+y];
                if(union(nodes[x*n+y], near))
                    num--;
            }
            if(isLand(x+1,y,nodes,m,n)){
                Land near = nodes[(x+1)*n+y];
                if(union(nodes[x*n+y], near))
                    num--;
            }
            if(isLand(x,y-1,nodes,m,n)){
                Land near = nodes[x*n+y-1];
                if(union(nodes[x*n+y], near))
                    num--;
            }
            if(isLand(x,y+1,nodes,m,n)){
                Land near = nodes[x*n+y+1];
                if(union(nodes[x*n+y], near))
                    num--;
            }

            res.add(num);
        }

        return res;
    }

    public Land root(Land land){
        if(land.parent==null)
            return land;
        else{
            Land root = root(land.parent);
            land.parent = root;
            return root;
        }
    }

    public boolean isLand(int x, int y, Land[] nodes, int m, int n){
        if(x<0 || x>=m || y<0 || y>=n){
            return false;
        } else{
            return nodes[x*n+y]!=null;
        }
    }

    public boolean union(Land node1, Land node2){

        Land r1 = root(node1);
        Land r2 = root(node2);

        if(r1==r2)
            return false;
        else{
            r1.parent = r2;
            return true;
        }
    }
}

class Land{

    Land parent;
    int x;
    int y;

    public Land(int x, int y){
        this(null, x, y);
    }

    public Land(Land parent, int x, int y){
        this.parent = parent;
        this.x = x;
        this.y = y;
    }
}
