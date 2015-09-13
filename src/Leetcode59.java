/**
 * Created by qixuanwang on 15/9/13.
 */
public class Leetcode59 {

    public static void main(String[] args) {

    }

    public static int[][] generateMatrix(int n) {


        int[][] matrix = new int[n][n];
        if(n==0)
            return matrix;

        int start = 0;
        int element = 1;
        for(int len = n;len>0;len-=2){
            if(len==1){
                matrix[start][start] = element++;
                return matrix;
            }
            else if(len==2){
                matrix[start][start] = element++;
                matrix[start][start+1] = element++;
                matrix[start+1][start+1] = element++;
                matrix[start+1][start] = element++;
                return matrix;
            }
            else{
                for(int i=0;i<len;i++)
                    matrix[start][start+i] = element++;
                for(int i=1;i<len;i++)
                    matrix[start+i][start+len-1] = element++;
                for(int i=1;i<len;i++)
                    matrix[start+len-1][start+len-1-i] = element++;
                for(int i=1;i<len-1;i++)
                    matrix[start+len-1-i][start] = element++;
                start++;
            }
        }

        return matrix;
    }
}
