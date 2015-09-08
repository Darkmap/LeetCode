/**
 * Created by qixuanwang on 15/9/1.
 */
public class Leetcode34 {

    public static void main(String[] args) {

        int[] a = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7);
        for(int it:a)
            System.out.print(it + " ");
    }

    public static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length;
        while(start<end){
            int med = (start+end)/2;
            if(nums[med]==target){
                int head = med;
                //当med在边界时,必须控制边界
                while(head>0 && nums[head-1]==target)
                    head--;
                int tail = med;
                while(tail+1<nums.length && nums[tail+1]==target)
                    tail++;

                return new int[] {head,tail};
            }
            else if(nums[med]<target){
                start = med+1;
            }
            else{
                end = med;
            }
        }
        return new int[] {-1,-1};
    }
}
