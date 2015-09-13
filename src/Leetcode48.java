/**
 * Created by qixuanwang on 15/9/10.
 */
public class Leetcode48 {

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix){
        int n = matrix.length;
        for(int y=0;y<n;y++){
            for(int x=0;x<n;x++){
                System.out.print(matrix[y][x]+"\t");
            }
            System.out.println();
        }
    }


    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        int[][] newMatrix = new int[n][n];

        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){

                int newX = y;
                int newY = n-1-x;

                newMatrix[newX][newY] = matrix[x][y];

            }
        }

        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){

                matrix[x][y] = newMatrix[x][y];

            }
        }

    }

}
