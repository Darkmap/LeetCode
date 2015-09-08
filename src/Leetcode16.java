import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 15/8/26.
 */
public class Leetcode16 {



    public static void main(String[] args){

        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }


    public static int threeSumClosest(int[] nums, int target) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int num: nums){
            numList.add(num);
        }

        Collections.sort(numList);


        List<List<Integer>> output = new ArrayList<List<Integer>>();


        int value = 0;
        int distance = Integer.MAX_VALUE;

        for(int begin=0;begin<nums.length-2;begin++){
            int mid = begin+1;
            int end = nums.length-1;

            while(mid<end){

                int sum = numList.get(begin)+numList.get(mid)+numList.get(end);

                if(sum == target){
                    return target;
                }
                else if(sum > target){

                    if(sum-target<distance){
                        value = sum;
                        distance = sum-target;
                    }

                    end--;
                }
                else{
                    if(target-(sum)<distance){
                        value = sum;
                        distance = target-(sum);
                    }

                    mid++;
                }
            }

        }


        return value;
    }

}
