/**
 * Created by qixuanwang on 16/2/27.
 */
public class Leetcode265 {

    public static void main(String[] args) {

        int[][] costs = {{1,5,3},{2,9,4}};

        Leetcode265 lt = new Leetcode265();
        System.out.println(lt.minCostII(costs));
    }

    public int minCostII(int[][] costs) {

        if(costs==null || costs.length==0 || costs[0].length==0)
            return 0;

        int n = costs.length;
        int k = costs[0].length;

        // int[][] dp = new int[n][k];

        int preMin = 0;
        int preSecMin = 0;
        int preIdx = -1;

        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            int secMin = Integer.MAX_VALUE;

            for(int j=0;j<k;j++){
                int cost = costs[i][j];
                if(j==preIdx){
                    cost += preSecMin;
                } else{
                    cost += preMin;
                }
                if(minIdx<0){
                    min = cost;
                    minIdx = j;
                } else if(cost<min){
                    secMin = min;
                    minIdx = j;
                    min = cost;

                } else if(cost<secMin){
                    secMin = cost;
                }

            }

            preMin = min;
            preSecMin = secMin;
            preIdx = minIdx;

        }

        return preMin;
    }
}
