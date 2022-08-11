package LeetCode;

import tools.TreeNode;

public class code226 {

    public static TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode temp;
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            if(root.left!=null){
                invertTree(root.left);
            }
            if(root.right!=null){
                invertTree(root.right);
            }
            return root;
        }   
        else{
            return root;
        }     
    }

    public static void main(String[] args){
        TreeNode root_01=new TreeNode(1);
        TreeNode leaf_01=new TreeNode(2);
        TreeNode leaf_02=new TreeNode(3);
        root_01.right=leaf_01;
        leaf_01.left=leaf_02;
        invertTree(root_01);
    } 
    
}
