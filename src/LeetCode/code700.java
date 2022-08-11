package LeetCode;

import tools.binary_tree;

public class code700 {

    // 返回子树，其实就是返回那个节点
    public static binary_tree searchBST(binary_tree root, int val) {
        // 终止条件
        if(root==null){
            return null;
        }
        else{
            binary_tree result_root;
            if(root.value==val){
                return root;
            }
            else{
                if(root.value>val){
                    result_root=searchBST(root.left, val);
                }
                else{
                    result_root=searchBST(root.right, val);
                }
                return result_root;
            }
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
        searchBST(root_01, 4);
    }
}
