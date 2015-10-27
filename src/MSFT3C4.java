import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/23.
 */
public class MSFT3C4 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));

        List<List<Integer>> matrix1 = new LinkedList<>();
        List<List<Integer>> matrix2 = new LinkedList<>();

        while(in.hasNext()){
            String line = (in.nextLine());
            String[] lines = line.split("\\u007C");

            List<Integer> list1 = new LinkedList<>();
            List<Integer> list2 = new LinkedList<>();


            for(String numStr: lines[1].split(" ")){
                if(numStr.length()>0){
                    int num = Integer.valueOf(numStr);
                    list1.add(num);
                }
            }
            matrix1.add(list1);

            if(lines.length>2){
                for(String numStr: lines[3].split(" ")){

                    if(numStr.length()>0) {
                        int num = Integer.valueOf(numStr);
                        list2.add(num);
                    }
                }
                matrix2.add(list2);
            }
        }

        int m = matrix1.size();
        int med = matrix1.get(0).size();
        int n = matrix2.get(0).size();


        int[][] res = new int[m][n];

        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                int sum = 0;
                for(int i=0;i<med;i++){
                    sum += matrix1.get(x).get(i)
                            * matrix2.get(i).get(y);
                }
                res[x][y] = sum;
            }
        }

        for(int i=0;i<m;i++){
            System.out.print("|");
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println("|");
        }
    }
}
