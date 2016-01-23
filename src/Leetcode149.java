import java.util.HashMap;

/**
 * Created by qixuanwang on 16/1/20.
 */
public class Leetcode149 {

    public static void main(String[] args) {

    }

    public static int maxPoints(Point[] points) {
        int len = points.length;

        HashMap<Double,Integer> map = new HashMap<>();

        int max = 0;

        for(int i=0;i<len;i++){

            map.clear();
            map.put(Double.MAX_VALUE,0);
            int same = 1;

            for(int j=0;j<len;j++){
                if(i!=j){
                    Point p1 = points[i];
                    Point p2 = points[j];
                    if(p1.x==p2.x && p1.y==p2.y)
                        same++;
                    if(p1.x==p2.x){
                        map.put(Double.MAX_VALUE,map.get(Double.MAX_VALUE)+1);
                    }
                    double key = (p1.y-p2.y)*1.0/(p1.x-p2.x);
                    if(map.containsKey(key)){
                        map.put(key,map.get(key)+1);
                    }
                    else
                        map.put(key,1);
                }
            }

            for(int num: map.values()){
                max = Math.max(max, num+same);
            }
        }

        return max;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}