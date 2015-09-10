import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/9.
 */
public class Leetcode46 {

    public static void main(String[] args) {

        int[] nums = {1,1,2,2};
        List<List<Integer>> outList = permute(nums);

        for(List<Integer> list: outList){
            for(Integer i: list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> outList = new ArrayList<>();

        List<Integer> curPermutation = new ArrayList<>();
        for(int num: nums){
            curPermutation.add(num);
        }
        outList.add(curPermutation);


        do{
            curPermutation = nextPermutation(curPermutation);
            if(curPermutation!=null)
                outList.add(curPermutation);
        }while(curPermutation!=null);

        return outList;
    }

    public static List<Integer> nextPermutation(List<Integer> curPermutation){

        List<Integer> nextPermutation = new ArrayList<>();
        nextPermutation.addAll(curPermutation);

        int len = nextPermutation.size();

        int idx = len-1;

        while(idx>0){
            if(nextPermutation.get(idx)>nextPermutation.get(idx-1))
                break;
            else
                idx--;
        }

        if(idx==0)
            return null;

        int greaterIdx = idx;
        for(int i=idx+1;i<len;i++){
            if(nextPermutation.get(i)<nextPermutation.get(greaterIdx) && nextPermutation.get(i)>nextPermutation.get(idx-1))
                greaterIdx = i;
        }

        int tmp = nextPermutation.get(idx-1);
        nextPermutation.set(idx-1, nextPermutation.get(greaterIdx));
        nextPermutation.set(greaterIdx, tmp);

        Collections.sort(nextPermutation.subList(idx, len));
        return nextPermutation;
    }

    public static void nextPermutation(int[] nums) {

        int len = nums.length;

        if(len==0)
            return;
        if(len==1)
            return;

        int idx = len-1;

        int start = 0;

        while(idx>0){

            if(nums[idx]>nums[idx-1]){
                start = idx;
                break;
            }
            else {
                idx--;
            }
        }

        if(idx==0){
            Arrays.sort(nums, idx, len);
            return;
        }

        int greaterIdx = idx;
        for(int i=idx+1;i<len;i++){
            if(nums[i]<nums[greaterIdx] && nums[i]>nums[idx-1])
                greaterIdx = i;
        }

        int tmp = nums[idx-1];
        nums[idx-1] = nums[greaterIdx];
        nums[greaterIdx] = tmp;

        Arrays.sort(nums, idx, len);

    }
}
