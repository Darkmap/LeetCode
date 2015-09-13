/**
 * Created by qixuanwang on 15/9/11.
 */
public class Leetcode53 {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray2(nums));

    }


    public static int maxSubArray2(int[] nums) {

        int currMax=nums[0],max=nums[0];

        for(int i=1;i<nums.length;i++){

            currMax=Math.max(currMax+nums[i],nums[i]);
            max=Math.max(max,currMax);
        }

        return max;
    }

    public static int maxSubArray(int[] nums) {

        int len = nums.length;
        int max = Integer.MIN_VALUE;


        int sum = 0;

        for(int i=1;i<=len;i++){
            for(int j=0;j<=len-i;j++){
                sum = 0;
                for(int idx=j;idx<j+i;idx++){
                    sum += nums[idx];
                }
                if(max<sum)
                    max = sum;
            }
        }

        return max;
    }


}
