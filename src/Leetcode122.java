/**
 * Created by qixuanwang on 15/10/1.
 */
public class Leetcode122 {

    public static void main(String[] args) {

        int[] prices = {1,2,3,4,3,4,5,6,5,4,3,2,1,2,3,4,5,6,7,8};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int p = 0;
        if(prices.length==0)
            return 0;

        int min = prices[0];
        for(int i=0;i<prices.length;i++){

            if(min>prices[i]){
                min = prices[i];
                if(prices[i]<prices[i-1]){
                    maxProfit += p;
                    p=0;
                }
            }
            else{
                int cur = prices[i] - min;
                if(cur>p){
                    p = cur;
                }
                else{
                    maxProfit += p;
                    min = prices[i];
                    p=0;
                }
            }
        }
        return maxProfit+p;
    }
}
