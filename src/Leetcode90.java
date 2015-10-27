import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/21.
 */
public class Leetcode90 {

    public static void main(String[] args) {

        int[] nums = {1,2,2};

        List<List<Integer>> res = subsetsWithDup(nums);

        for(List<Integer> list: res) {
            for (int token : list){
                System.out.print(token+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();

        List<Integer> zero = new LinkedList<>();
        res.add(zero);

        int len = nums.length;
        if(len==0)
            return res;


        Arrays.sort(nums);

        subsetDupHelper(res, new LinkedList<>(), -1, len, nums);

        return res;
    }

    public static void subsetDupHelper(List<List<Integer>> res, List<Integer> list, int lastIdx, int len, int[] nums){

        if(lastIdx >= len-1)
            return;

        for(int i=lastIdx+1;i<len;i++){

            List<Integer> newList = new LinkedList<>(list);
            newList.add(nums[i]);
            res.add(newList);
            subsetDupHelper(res, newList, i, len, nums);

            while(i+1<len && nums[i]==nums[i+1])
                i++;
        }
    }




















}
