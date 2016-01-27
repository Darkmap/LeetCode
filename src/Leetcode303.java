/**
 * Created by qixuanwang on 16/1/26.
 */
public class Leetcode303 {
    public static void main(String[] args) {

        int[] nums = {-2,0,3,-5,2,-1};
        NumArray2 na = new NumArray2(nums);

        System.out.println(na.sumRange(0,2));
    }
}

class NumArray2 {

    int[] sums;

    public NumArray2(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sums[i] = sums[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return sums[j];
        else
            return sums[j]-sums[i-1];
    }
}