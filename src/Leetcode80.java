/**
 * Created by qixuanwang on 15/9/19.
 */
public class Leetcode80 {

    public static void main(String[] args) {

        int[] nums = {1,1,1,1};
        int len = removeDuplicates(nums);
        for(int i=0;i<len;i++){
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {

        int len = nums.length;
        if(len<=2)
            return len;

        int max = nums[0];
        int count = 1;
        int length = 1;

        for(int i=1;i<len;i++){


            while(i<len && nums[i]==max && count == 2){
                i++;
            }
            if(i>=len)
                break;

            if(nums[i]==max && count == 1){
                nums[length] = nums[i];
                max = nums[i];
                length++;
                count++;
            }
            else if(nums[i]>max){
                nums[length] = nums[i];
                max = nums[i];
                count=1;
                length++;
            }
        }

        return length;
    }
}
