/**
 * Created by qixuanwang on 16/2/26.
 */
public class Leetcode106 {

    public static void main(String[] args) {


        int[] post = {4,5,2,6,7,3,1};
        int[] in = {4,2,5,1,6,3,7};

        Leetcode106 lt = new Leetcode106();
        lt.buildTree(in,post);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || inorder==null)
            return null;
        if(postorder.length!=inorder.length)
            return null;

        int len = postorder.length;

        return helper(inorder,0,len-1,postorder,0,len-1);
    }

    public TreeNode helper(int[] inorder, int b1, int e1, int[] postorder, int b2, int e2){

        if(e1<b1){
            return null;
        } else if(e1==b1){
            return new TreeNode(inorder[b1]);
        } else{

            int root = postorder[e2];
            int l11 = b1;
            int r11 = b1-1;
            for(int i=b1;i<=e1;i++){
                if(root==inorder[i]){
                    r11 = i-1;
                    break;
                }
            }

            int llen = r11-l11+1;

            int l21 = b2;
            int r21 = b2+llen-1;

            int l12 = r11+2;
            int r12 = e1;

            int l22 = r21+1;
            int r22 = e2-1;

            TreeNode head = new TreeNode(root);
            head.left = helper(inorder,l11,r11,postorder,l21,r21);
            head.right = helper(inorder,l12,r12,postorder,l22,r22);
            return head;
        }

    }
}
