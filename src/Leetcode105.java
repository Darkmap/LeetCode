/**
 * Created by qixuanwang on 16/2/26.
 */
public class Leetcode105 {

    public static void main(String[] args) {

        int[] pre = {1,2,3};
        int[] in = {3,2,1};

        Leetcode105 lt = new Leetcode105();
        lt.buildTree(pre,in);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || inorder==null)
            return null;
        if(preorder.length!=inorder.length)
            return null;

        int len = preorder.length;

        return helper(preorder,0,len-1,inorder,0,len-1);
    }

    public TreeNode helper(int[] preorder, int b1, int e1, int[] inorder, int b2, int e2){

        if(e1<b1){
            return null;
        }
        else if(e1==b1){
            return new TreeNode(preorder[e1]);
        } else{
            int root = preorder[b1];
            int l21 = b2;
            int r21 = b2-1;
            for(int i=b2;i<=e2;i++){
                if(root==inorder[i]){
                    r21 = i-1;
                    break;
                }
            }

            int llen = r21-l21+1;

            int l22 = r21+2;
            int r22 = e2;

            int l11 = b1+1;
            int r11 = b1+llen;
            int l12 = r11+1;
            int r12 = e1;

            TreeNode head = new TreeNode(root);
            head.left = helper(preorder,l11,r11,inorder,l21,r21);
            head.right = helper(preorder,l12,r12,inorder,l22,r22);
            return head;
        }
    }
}
