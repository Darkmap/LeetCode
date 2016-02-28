import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 16/2/26.
 */
public class Leetcode254 {


    public static void main(String[] args) {

        Leetcode254 lt = new Leetcode254();
        for(List<Integer> list: lt.getFactors(12)){
            for(int num: list)
                System.out.print(num + "\t");
            System.out.println();
        }
    }

    public List<List<Integer>> getFactors(int n) {

        List<List<Integer>> res = new ArrayList<>();

        if(n<=1)
            return res;
        helper(res,n,new ArrayList<>());

        return res;
    }

    public void helper(List<List<Integer>> res, int n, List<Integer> pre){

        int begin = 2;
        if(pre.size()>0){
            begin = pre.get(pre.size()-1);
        }

        int end = (int)(Math.sqrt(n));
        for(int i=begin;i<=end;i++){
            if(n%i==0){
                if(n/i==1){
                    List<Integer> newList = new ArrayList<>(pre);
                    newList.add(i);
                    res.add(newList);
                } else if(n/i>=i){
                    List<Integer> newList = new ArrayList<>(pre);
                    List<Integer> newList2 = new ArrayList<>(pre);
                    newList.add(i);
                    newList2.add(i);
                    newList.add(n/i);
                    res.add(newList);
                    helper(res, n / i, newList2);
                }
            }
        }
    }
}
