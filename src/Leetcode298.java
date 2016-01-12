import java.util.Stack;

/**
 * Created by qixuanwang on 15/12/14.
 */
public class Leetcode298 {

    static int max = 0;


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(1);


        System.out.println(longestConsecutive(root));
    }

    public static int longestConsecutive(TreeNode root) {

        helper(root);
        return max;

    }

    public static Stack<Integer> helper(TreeNode root){

        Stack<Integer> res  = new Stack<>();

        if(root.left==null && root.right==null){
            res.add(root.val);
            return res;
        }

        Stack<Integer> left = null;
        Stack<Integer> right = null;

        if(root.left!=null){
            left = helper(root.left);
            if(root.val-root.left.val==-1)
                res = left;
        }

        if(root.right!=null){
            right = helper(root.right);
            if(root.val-root.right.val==-1 && res.size()<right.size())
                res = right;
        }

        res.add(root.val);
        max = Math.max(res.size(),max);
        return res;
    }
}
