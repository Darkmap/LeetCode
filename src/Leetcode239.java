import java.util.LinkedList;

/**
 * Created by qixuanwang on 16/1/23.
 */
public class Leetcode239 {

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};

        for(int num: maxSlidingWindow(nums,3)){
            System.out.println(num);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length==0)
            return new int[0];

        int idx = 0;
        int[] res = new int[nums.length-k+1];
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0;i<k;i++){
            while(!list.isEmpty() && nums[i] > nums[list.getLast()]){
                list.removeLast();
            }
            list.add(i);
        }
        res[idx++] = nums[list.getFirst()];

        for(int i=k;i<nums.length;i++){

            if(list.getFirst() == i-k){
                list.removeFirst();
            }
            while(!list.isEmpty() && nums[i] > nums[list.getLast()]){
                list.removeLast();
            }
            list.add(i);
            res[idx++] = nums[list.getFirst()];
        }

        return res;
    }
}
