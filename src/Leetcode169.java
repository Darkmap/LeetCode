import java.util.HashMap;

/**
 * Created by qixuanwang on 15/10/31.
 */
public class Leetcode169 {

    public static void main(String[] args) {

        int [] nums = {7,7,7,8,8};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num: nums){
            if(map.containsKey(num)){
                int count = map.get(num);
                count++;
                if(count > (nums.length/2))
                    return num;
                map.put(num, count);
            }
            else
                map.put(num, 1);
        }
        return nums[nums.length-1];
    }
}
