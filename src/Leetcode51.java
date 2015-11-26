import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qixuan on 2015/11/26.
 */
public class Leetcode51 {

    public static void main(String[] args) {

        List<List<String>> res = solveNQueens(4);
        for(List<String> sol : res){
            for(String str: sol)
                System.out.println(str);
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        if(n==0)
            return res;

        nqHelper(res, new ArrayList<>(), n);

        return res;
    }

    public static void nqHelper(List<List<String>> res, List<Integer> last, int n){

        int curRow = last.size();
        if(curRow==n){
            res.add(translate(last));
        }
        else{

            int[] flag = new int[n];
            for(int i=0;i<curRow;i++){
                int j = last.get(i);
                flag[j]=1;
                int len = curRow-i;
                if(len+j<n)
                    flag[len+j]=1;
                if(j-len>=0)
                    flag[j-len]=1;
            }
            for(int i=0;i<n;i++){
                List<Integer> newLast = new ArrayList<>(last);
                if(flag[i]==0){
                    newLast.add(i);
                    nqHelper(res, newLast, n);
                }
            }
        }
    }

    public static List<String> translate(List<Integer> last){
        List<String> res = new ArrayList<>();
        for(int i=0;i<last.size();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<last.size();j++){
                sb.append((j==last.get(i))?"Q":".");
            }
            res.add(sb.toString());
        }
        return res;
    }
}
