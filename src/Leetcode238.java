/**
 * Created by qixuanwang on 15/11/10.
 */
public class Leetcode238 {

    public static void main(String[] args) {

        String a = "abcd";

        int[][] matrix = {

                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(matrix,5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int xlen = matrix.length;
        if(xlen==0)
            return false;
        int ylen = matrix[0].length;
        if(ylen==0)
            return false;

        return search(matrix,target,0,0,xlen-1,ylen-1);
    }

    public static boolean search(int[][] matrix, int target, int x0, int y0, int x1, int y1){

        if(x0==x1 && y0==y1){
            return target==matrix[x0][y0];
        }
        else if(x0>x1 || y0>y1){
            return false;
        }
        else{
            int x = (x1+x0)/2;
            int y = (y1+y0)/2;

            if(target==matrix[x][y]){
                return true;
            }
            else if(target>matrix[x][y]){
                return search(matrix,target,x0,y+1,x1,y1)
                        || search(matrix,target,x+1,y0,x1,y);
            }
            else{
                return search(matrix,target,x0,y0,x-1,y1)
                        || search(matrix,target,x,y0,x1,y-1);
            }
        }
    }
}
