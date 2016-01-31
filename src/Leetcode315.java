import java.util.ArrayList;
import java.util.List;
/**
 * Created by qixuanwang on 16/1/28.
 */
public class Leetcode315 {

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        for(int num: countSmaller(nums)){
            System.out.println(num);
        }
    }

    public static List<Integer> countSmaller(int[] nums) {

        int[] res = new int[nums.length];
        res[nums.length-1] = 0;

        CBSTNode root = new CBSTNode(nums[nums.length-1]);

        for(int i=nums.length-2;i>=0;i--){
            CBSTNode cur = new CBSTNode(nums[i]);
            res[i] = insert(root,cur,0);
        }

        List<Integer> list = new ArrayList<>();
        for(int num: res){
            list.add(num);
        }
        return list;
    }

    public static int insert(CBSTNode root, CBSTNode add, int small){
        if(root.val == add.val){
            root.count++;
            return small + root.leftcount;
        }
        else if(root.val > add.val){
            if(root.left==null){
                root.left = add;
                root.leftcount++;
                return small;
            }
            else{
                root.leftcount++;
                return insert(root.left, add, small);
            }
        }
        else{
            if(root.right==null){
                small += root.count+root.leftcount;
                root.right = add;
                return small;
            }
            else{
                small += root.count+root.leftcount;
                return insert(root.right,add,small);
            }
        }
    }
}


class CBSTNode{
    int val;
    CBSTNode left;
    CBSTNode right;
    int count;
    int leftcount;

    public CBSTNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
        this.count = 1;
        this.leftcount = 0;
    }
}