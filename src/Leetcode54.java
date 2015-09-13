import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/13.
 */
public class Leetcode54 {

    public static void main(String[] args) {


        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        List<Integer> outputList = spiralOrder2(matrix);

        for(int i: outputList){
            System.out.println(i);
        }

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int len = matrix.length;

        return spiralOrderHelper(matrix, 0, len);

    }

    /**
     * 这个是最佳的解答,把不必要的递归改为迭代,且适应m*n非正方形矩阵的情况
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder2(int[][] matrix) {

        List<Integer> outputList = new ArrayList<>();

        int lenX = matrix.length;
        if(lenX==0)
            return outputList;
        int lenY = matrix[0].length;
        if(lenY==0)
            return outputList;


        int x = 0;

        for(int n=lenX,m=lenY;n>0&&m>0;n-=2,m-=2){

            if(n==1){
                for(int i=0;i<m;i++){
                    outputList.add(matrix[x][x+i]);
                }
            }
            else if(m==1){
                for(int i=0;i<n;i++){
                    outputList.add(matrix[x+i][x]);
                }
            }
            else{
                for(int i=0;i<m;i++){
                    outputList.add(matrix[x][x+i]);
                }
                for(int i=0;i<n-1;i++){
                    outputList.add(matrix[x+1+i][x+m-1]);
                }
                for(int i=0;i<m-1;i++){
                    outputList.add(matrix[x+n-1][x+m-2-i]);
                }
                for(int i=0;i<n-2;i++){
                    outputList.add(matrix[x+n-2-i][x]);
                }
            }
            x++;
        }

        return outputList;


    }

    public static List<Integer> spiralOrderHelper(int[][] matrix, int x, int n){

        List<Integer> outputList = new ArrayList<>();

        if(n==2){
            outputList.add(matrix[x][x]);
            outputList.add(matrix[x][x+1]);
            outputList.add(matrix[x+1][x+1]);
            outputList.add(matrix[x+1][x]);

            return outputList;
        }
        else if(n==1){
            outputList.add(matrix[x][x]);

            return outputList;
        }
        else{

            for(int i=0;i<n;i++){
                outputList.add(matrix[x][x+i]);
            }
            for(int i=0;i<n-1;i++){
                outputList.add(matrix[x+1+i][x+n-1]);
            }
            for(int i=0;i<n-1;i++){
                outputList.add(matrix[x+n-1][x+n-2-i]);
            }
            for(int i=0;i<n-2;i++){
                outputList.add(matrix[x+n-2-i][x]);
            }
            outputList.addAll(spiralOrderHelper(matrix, x+1, n-2));
            return outputList;
        }

    }
}
