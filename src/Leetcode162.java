/**
 * Created by qixuanwang on 15/10/29.
 */
public class Leetcode162 {

    public static void main(String[] args) {

        int[] nums = {3, 2, 1};

        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len==1)
            return 0;

        int begin = 0;
        int end = len-1;
        while(begin<=end){
            int m = (begin+end)/2;
            if(m==0){
                if(nums[m]>nums[m+1])
                    return m;
                else
                    begin = m+1;
            }
            else if(m==len-1){
                if(nums[m]>nums[m-1])
                    return m;
                else
                    end = m-1;
            }
            else{
                if(nums[m]>nums[m-1] && nums[m]>nums[m+1])
                    return m;
                else if(nums[m]>nums[m-1] && nums[m]<nums[m+1])
                    begin = m+1;
                else if(nums[m]<nums[m-1] && nums[m]>nums[m+1])
                    end = m-1;
                else
                    begin = m+1;
            }
        }

        return begin;

    }
}
