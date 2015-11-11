/**
 * Created by qixuanwang on 15/11/10.
 */
public class Leetcode236 {

    static TreeNode res = null;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(lowestCommonAncestor(root, root.right, root.left).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return res;
    }

    public static int find(TreeNode root, TreeNode p, TreeNode q){


        if(res!=null){
            return 0;
        }
        else{
            if(root==null){
                return 0;
            }
            else if(root==p || root==q){
                int newVal = 1;
                newVal += find(root.left, p, q);
                if(res==null && newVal==2){
                    res = root;
                    return newVal;
                }
                newVal += find(root.right, p, q);
                if(res==null && newVal==2){
                    res = root;
                }
                return newVal;
            }
            else{
                int newVal = 0;
                newVal += find(root.left, p, q);
                newVal += find(root.right, p, q);
                if(res==null && newVal==2){
                    res = root;
                }
                return newVal;
            }

        }
    }
}
