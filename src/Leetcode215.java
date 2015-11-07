/**
 * Created by qixuanwang on 15/11/6.
 */
public class Leetcode215 {

    public static void main(String[] args) {

        int[] nums = {3,1,2,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        return findKthHelper(nums, k, 0, len-1);
    }

    public static int findKthHelper(int[] nums, int k, int i, int j){

        if(i==j)
            return nums[i];

        int head = i;
        int begin = i+1;
        int end = j;

        while(begin<j && nums[begin]>nums[head]){
            begin++;
        }
        while(end>i && nums[end]<nums[head]){
            end--;
        }

        while(begin<=end){
            while(begin<=j && nums[begin]>nums[head]){
                begin++;
            }
            while(end>=i && nums[end]<nums[head]){
                end--;
            }
            if(begin<=end){
                int tmp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = tmp;

                begin++;
                end--;
            }
            else{
                break;
            }
        }

        int tmp = nums[end];
        nums[end] = nums[head];
        nums[head] = tmp;


        int pre = end-head;


        if(pre>=k){
            return findKthHelper(nums, k, i, end-1);
        }
        else if(pre==0){
            if(k==1)
                return nums[end];
            else
                return findKthHelper(nums, k-1, end+1, j);
        }
        else
            return findKthHelper(nums, k-pre, end, j);

    }
}
