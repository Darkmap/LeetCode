import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by qixuanwang on 15/9/13.
 */
public class Leetcode60 {

    public static void main(String[] args) {

        Leetcode60 lt = new Leetcode60();

        System.out.println(lt.getPermutation(4, 8));
    }

    /**
     * Pruning thought, extended by the method2
     */
    public String getPermutation(int n, int k) {

        int sum = 1;
        for(int i=1;i<=n;i++){
            sum *= i;
        }

        int count = 0;

        int[] map = new int[n+1];
        Arrays.fill(map,1);

        String res = "";

        while(res.length()<n){

            int curLevel = n-res.length();
            int subSum = sum/curLevel;
            for(int i=1;i<=n;i++){
                if(map[i]>0){
                    if((count+subSum) >= k){
                        res = res + i;
                        map[i]--;
                        break;
                    } else{
                        count += subSum;
                    }
                }
            }
            sum = subSum;
        }

        return res;
    }


    /**
     * DFS + Pruning, still TLE
     */
    int res_count = 0;
    int subSum = 0;
    public String getPermutation2(int n, int k) {

        int i = 1;
        int sum = 1;
        for(;i<=n;i++){
            sum *= i;
            if(sum>=k)
                break;
        }

        subSum = sum/i;

        int idx = 1;
        for(;idx<=i;idx++){
            if(subSum*idx>=k){
                break;
            }
        }

        int[] count = new int[n+1];
        Arrays.fill(count,1);

        List<String> res = new ArrayList<>();

        helper(res, count, n, k, "", i, idx);

        return res.get(res.size()-1);
    }

    public void helper(List<String> res, int[] count, int n, int k, String pre, int level, int idx){
        if(pre.length()==n){
            res.add(pre);
            res_count++;
        } else if(res_count<k){

            int curLevel = n-pre.length();
            int curIdx = 0;

            for(int i=1;i<=n;i++){
                if(count[i]>0){
                    curIdx++;
                    int[] newCount = Arrays.copyOf(count, count.length);
                    newCount[i]--;
                    if(curLevel>level){
                        helper(res,newCount,n,k,pre+i,level,idx);
                        break;
                    } else if(curLevel==level){
                        if(curIdx<idx){
                            res_count += subSum;
                        } else if(curIdx==idx){
                            helper(res,newCount,n,k,pre+i,level,idx);
                            break;
                        }
                    } else{
                        helper(res,newCount,n,k,pre+i,level,idx);
                    }
                }
            }
        }
    }


    /**
     * Some brute-force method. TLE
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation3(int n, int k) {


        int[] nums = new int[n];
        StringBuffer a = new StringBuffer("");

        if(n==0)
            return a.toString();
        if(n==1)
            return "1";


        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }


        for(int i=1;i<k;i++){
            nextPermutation(nums,n);
        }




        for(int i=0;i<n;i++){
            a.append(nums[i]);
        }
        return a.toString();
    }

    public static void nextPermutation(int[] nums, int n){


        int i=n-1;
        for(;i>0;i--){
            if(nums[i]>nums[i-1])
                break;
        }

        int nextIdx = i;
        for(int idx = i+1;idx<n;idx++){
            if(nums[idx]<nums[i] && nums[idx]>nums[i-1])
                nextIdx = idx;
        }
        int tmp = nums[nextIdx];
        nums[nextIdx] = nums[i-1];
        nums[i-1] = tmp;

        Arrays.sort(nums, i, n);
    }

}
