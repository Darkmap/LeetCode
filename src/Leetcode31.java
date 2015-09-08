import java.util.Arrays;

/**
 * Created by qixuanwang on 15/8/30.
 */
public class Leetcode31 {

    public static void main(String[] args) {

        int[] nums = {1,1};
        nextPermutation(nums);
        for(int itr: nums)
            System.out.print(itr+" ");
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

        /*
            又忘了处理特殊情况
         */
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
