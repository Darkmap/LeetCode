import java.util.LinkedList;

/**
 * Created by qixuanwang on 15/9/13.
 */
public class Leetcode55 {

    public static void main(String[] args) {

        int[] nums = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};

        System.out.println(canJump2(nums));
    }


    /**
     * 模拟了真实的游戏进程, 这里有一个trick:每次只向前跳一步,然后观察自己还能跳多少步, 原理在于:
     * 完成不了的情况就是当你到这个点时,你不能再跳了.
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums){

        int jumpLen = 1;
        int goal = nums.length;

        for(int i=0;i<goal;i++){

            jumpLen -= 1;

            if(i==goal-1)
                return true;
            else{
                if(jumpLen < nums[i])
                    jumpLen = nums[i];
            }

            if(jumpLen == 0)
                return false;

        }
        return false;
    }





    /**
     * 思路是对的,符合Agent的搜索思想,但是根据模型可以设计出远低于指数消耗的算法
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums){

        LinkedList<Integer> open = new LinkedList<>();

        int goal = nums.length;

        open.add(0);

        while(!open.isEmpty()){

            int curIdx = open.remove(0);
            if(curIdx==goal-1)
                return true;
            else{
                int jumpLen = nums[curIdx];
                for(int i=1;i<=jumpLen;i++) {
                    if(curIdx+i==goal-1)
                        return true;
                    if(curIdx+i<goal && nums[curIdx+i]!=0)
                        open.addFirst(curIdx+i);
                }
            }
        }
        return false;

    }
}
