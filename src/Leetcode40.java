import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/3.
 */
public class Leetcode40 {

    public static void main(String[] args) {

        int[] cans = {1};
        System.out.print(combinationSum2(cans, 4));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> outSet = new HashSet<List<Integer>>();

        iterativeHelper(candidates, target, 0, new ArrayList<Integer>(), outSet);

        outList.addAll(outSet);

        return outList;

    }

    public static void iterativeHelper(int[] candidates, int target,
                                       int begin, List<Integer> lastOut,
                                       HashSet<List<Integer>> outSet) {



        //该循环的意义:else if语句如果没找到,将产生branch,一边继续搜索下一个,一边target-can[i]
        for(int i=begin;i<candidates.length;i++){

            //必须新建一个,因为每次循环都需要新的中间结果
            List<Integer> out = new ArrayList<Integer>(lastOut);

            if(candidates[i]==target){
                out.add(candidates[i]);
                outSet.add(out);
                break;
            }
            else if(candidates[i]<target){
                out.add(candidates[i]);
                iterativeHelper(candidates, target-candidates[i], i+1, out ,outSet);
            }
            else{
                break;
            }
        }

    }
}
