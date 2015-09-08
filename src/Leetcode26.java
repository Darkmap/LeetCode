/**
 * Created by qixuanwang on 15/8/28.
 */
public class Leetcode26 {

    public static void main(String[] args) {

        int[] a = {1,1,2};
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int length = 0;

        for(int i=0;i<nums.length;i++){

            while(i<nums.length && nums[i]==max){

                i++;
            }

            if(i>=nums.length){
                break;
            }

            if(nums[i]>max){
                max = nums[i];
                length++;
                //要把冗余的duplicate nums换掉
                nums[i-(i-length+1)] = nums[i];
            }
        }

        return length;

    }


}
