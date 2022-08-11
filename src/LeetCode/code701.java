package LeetCode;

import tools.binary_tree;

public class code701 {

    public static binary_tree insertIntoBST(binary_tree root, int val) {
        // 可能为空树
        if(root==null){
            binary_tree root_temp=new binary_tree(val);
            return root_temp;
        }
        else{
            // 所有值不重复
            if(root.value<val){
                // 在右子树插入
                if(root.right==null){
                    root.right=insertIntoBST(root.right, val);
                }
                else{
                    insertIntoBST(root.right, val);
                }
            }
            else{
                if(root.left==null){
                    root.left=insertIntoBST(root.left, val);
                }
                else{
                    insertIntoBST(root.left, val);
                }
            }

            return root;
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
        insertIntoBST(root_01, 6);
    }
    
}
