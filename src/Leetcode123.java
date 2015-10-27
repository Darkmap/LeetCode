/**
 * Created by qixuanwang on 15/10/1.
 */
public class Leetcode123 {

    public static void main(String[] args) {

        int[] prices = {1,4,3,6,1,8};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int first = 0;
        int second = 0;
        int p = 0;
        if(prices.length==0)
            return 0;

        int min = prices[0];
        for(int i=0;i<prices.length;i++){

            if(min>prices[i]){
                min = prices[i];
                if(prices[i]<prices[i-1]){
                    if(p>first){
                        second = first;
                        first = p;
                    }
                    else if(p>second)
                        second = p;
                    p=0;
                }
            }
            else{
                int cur = prices[i] - min;
                if(cur>p){
                    p = cur;
                }
                else{
                    if(p>first){
                        second = first;
                        first = p;
                    }
                    else if(p>second)
                        second = p;
                    min = prices[i];
                    p=0;
                }
            }
        }

        if(p>first){
            second = first;
            first = p;
        }
        else if(p>second)
            second = p;

        return first+second;
    }
}
