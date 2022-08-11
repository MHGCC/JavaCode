// 以遍历解决
package LeetCode;

import tools.binary_tree;

public class code538_v2 {

    public static int sum;

    public static binary_tree convertBST(binary_tree root) {
        if(root==null){
            return null;
        }
        else{
            sum=0;
            inorder_value(root);

            return root;
        }
    }

    public static void inorder_value(binary_tree root){
        if(root!=null){
            inorder_value(root.right);
            sum=sum+root.value;
            root.value=sum;
            inorder_value(root.left);            
        }
    }
    

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(3);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(4);
        binary_tree leaf_03=new binary_tree(1);
        binary_tree leaf_04=new binary_tree(5);
        root_01.left=leaf_01;
        root_01.right=leaf_02;
        leaf_01.left=leaf_03;
        leaf_02.right=leaf_04;
        convertBST(root_01);
    }

}
