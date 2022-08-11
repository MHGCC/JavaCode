package LeetCode;
import tools.TreeNode;


//先翻转，再比较两棵树即可

public class code101 {
    
    public static TreeNode invertTree(TreeNode root,TreeNode root_symmetric) {
        if(root!=null){
            root_symmetric.val=root.val;
            if(root.right!=null){
                TreeNode left_symmetric=new TreeNode();
                root_symmetric.left=left_symmetric;
                invertTree(root.right,root_symmetric.left);
            }
            if(root.left!=null){
                TreeNode right_symmetric=new TreeNode();
                root_symmetric.right=right_symmetric;
                invertTree(root.left,root_symmetric.right);
            }
            return root_symmetric;
        }
        else{
            return null;
        }
    }
    
    public static boolean isSymmetric(TreeNode root) {
        TreeNode root_symmetric=new TreeNode();  
        TreeNode root_compare=invertTree(root, root_symmetric);
        Boolean flag=search_difference(root, root_compare);
        return flag;        
    }

    public static boolean search_difference(TreeNode root,TreeNode root_symmetric){
        if((root==null)||(root_symmetric==null)){
            if((root==null)&&(root_symmetric==null)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(root.val==root_symmetric.val){
                if((search_difference(root.left,root_symmetric.left))&&(search_difference(root.right,root_symmetric.right))){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args){
        TreeNode root_01=new TreeNode(1);
        TreeNode leaf_01=new TreeNode(2);
        TreeNode leaf_02=new TreeNode(2);
        root_01.right=leaf_01;
        root_01.left=leaf_02;
        isSymmetric(root_01);
    } 

}


