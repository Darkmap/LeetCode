import java.util.Stack;

/**
 * Created by qixuanwang on 16/1/17.
 */
public class Leetcode85 {

    public static void main(String[] args) {

        char[][] matrix = {{'1'}};

        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {

        int xlen = matrix.length;
        if(xlen==0)
            return 0;
        int ylen = matrix[0].length;
        if(ylen==0)
            return 0;

        int[][] hs = new int[xlen][ylen];

        for(int i=0;i<xlen;i++){
            for(int j=0;j<ylen;j++){
                if(matrix[i][j]=='0'){
                    hs[i][j]=0;
                }
                else{
                    hs[i][j] = i==0? 1 : 1+hs[i-1][j];
                }
            }
        }

        int res = 0;
        for(int i=0;i<xlen;i++){
            res = Math.max(res, maxRec(hs[i]));
        }

        return res;
    }

    public static int maxRec(int[] heights){

        int[] hs = new int[heights.length+1];
        for(int i=0;i<heights.length;i++){
            hs[i] = heights[i];
        }
        hs[heights.length]=0;

        Stack<Integer> stack = new Stack<>();

        int max = 0;

        for(int i=0;i<hs.length;i++){
            if(stack.isEmpty() || hs[stack.peek()] <= hs[i])
                stack.push(i);
            else{
                int tmp = stack.pop();
                max = Math.max(max, hs[tmp] * (stack.isEmpty()? i : i-stack.peek()-1));
                i--;
            }
        }

        return max;
    }
}
