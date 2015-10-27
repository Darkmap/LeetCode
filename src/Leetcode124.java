/**
 * Created by qixuanwang on 15/10/2.
 */
public class Leetcode124 {

    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {

        int len = prices.length;
        if(len <= 1) return 0;
        int a, b, c, d;
        d = Math.max(prices[len-1], prices[len-2]);
        c = Math.max(prices[len-1] - prices[len-2], 0);
        b = d;
        a = c;
        for(int i=len-3; i>=0; i--) {
            //在i点第一次买入的最大总收益
            a = Math.max(b - prices[i], a);
            //在i点第一次卖出收入中间值(未减第一次买入值时的中间值),加i+1,len里做的交易的收入
            b = Math.max(prices[i] + c, b);
            //在i点购入在i+1,len里卖出
            c = Math.max(d - prices[i], c);
            //i-len之间的最大值
            d = Math.max(prices[i], d);
        }
        return a;
    }
}
