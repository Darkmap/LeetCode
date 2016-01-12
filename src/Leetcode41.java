/**
 * Created by qixuanwang on 16/1/11.
 */
public class Leetcode41 {

    public static void main(String[] args) {

        int[] nums = {1,1};

        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int i=0;
        while(i<len){
            if(nums[i]>0 && nums[i]<=len){
                if(nums[i]==nums[nums[i]-1] && nums[i]!=i+1){
                    nums[nums[i]-1]=0;
                }

                int tmp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[tmp-1] = tmp;
            }
            else{
                nums[i]=0;
            }

            if(nums[i]==0 || nums[i]==i+1)
                i++;
        }

        for(i=0;i<len;i++){
            if(nums[i]==0){
                return i+1;
            }
        }
        return i+1;
    }
}
