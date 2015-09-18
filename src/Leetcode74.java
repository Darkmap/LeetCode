/**
 * Created by qixuanwang on 15/9/18.
 */
public class Leetcode74 {

    public static void main(String[] args) {


        int[][] matrix = {{1,3}};

        System.out.println(searchMatrix(matrix, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if(m==0)
            return false;
        int n = matrix[0].length;
        if(n==0)
            return false;

        int begin = 0;
        int end = m*n;
        int x = 0;
        int y = 0;
        while(begin<end){
            int mid = (begin+end)/2;
            x = mid / n;
            y = mid % n;
            if(matrix[x][y]==target)
                return true;
            else if(matrix[x][y]<target){
                begin = mid+1;
            }
            else{
                end = mid;
            }
        }

        //因为begin是mid+1,因此可能超过最大范围
        if(begin >= m*n)
            return false;

        int mid = begin;
        x = mid / n;
        y = mid % n;
        if(matrix[x][y]==target)
            return true;

        return false;
    }
}
