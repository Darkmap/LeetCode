import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/19.
 */
public class Leetcode78 {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);

        for(List<Integer> list: res){
            for(int token: list){
                System.out.print(token+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        /**
         * 注意:题目case有空集
         */
        res.add(new LinkedList<Integer>());

        subsetHelper(res, nums, -1, new LinkedList<Integer>(), nums.length);

        return res;
    }

    public static void subsetHelper(List<List<Integer>> res, int[] nums, int maxIdx, List<Integer> list, int len){

        if(maxIdx >= len-1)
            return;
        else{
            for(int i = maxIdx+1;i<len;i++){
                List<Integer> tmpList = new LinkedList<>(list);
                tmpList.add(nums[i]);
                res.add(tmpList);
                subsetHelper(res, nums, i, tmpList, len);
            }
        }
    }
}
