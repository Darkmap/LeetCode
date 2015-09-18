/**
 * Created by qixuanwang on 15/9/18.
 */
public class Leetcode73 {

    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        if(m==0)
            return;
        int n = matrix[0].length;
        if(n==0)
            return;

        boolean first_row_0 = false;
        boolean first_col_0 = false;


        /**
         *记录第一行和第一列是否需要全部置零
         *(因为第一行第一列将被作为标记用,如果不记录这个true/false,就没法完成对第一行第一列的正确置零)
         */
        for(int i=0;i<m;i++) {
            if(matrix[i][0]==0){
                first_col_0 = true;
                break;
            }
        }
        for(int i=0;i<n;i++) {
            if(matrix[0][i]==0){
                first_row_0 = true;
                break;
            }
        }

        /**
         * 发现元素为零,就用标记行(0)/列(0)做标记
         */
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        /**
         * 查询标记,置零,注意,这里必须从1行1列开始,因为不能影响标记位!!!
         */
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<n;j++)
                    matrix[i][j] = 0;
            }
        }
        for(int j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<m;i++)
                    matrix[i][j] = 0;
            }
        }

        /**
         * 完成首行/列的置零
         */

        if(first_row_0){
            for(int j=0;j<n;j++)
                matrix[0][j] = 0;
        }
        if(first_col_0){
            for(int i=0;i<m;i++)
                matrix[i][0] = 0;
        }
    }
}
