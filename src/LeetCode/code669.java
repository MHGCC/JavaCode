// 稍微麻烦了一些，就当复习删除节点了
package LeetCode;

import tools.binary_tree;

public class code669 {
    public static binary_tree trimBST(binary_tree root, int low, int high) {
        // 不存在空树，但需要给出结束条件，先使用遍历条件
        if(root==null){
            return null;
        }

        if(root.value<low){
            // cur的右子树会更新
            root.right=trimBST(root.right, low, high);
        }
        else if(root.value>high){
            root.left=trimBST(root.left, low, high);
        }
        else{
            // root要被修剪掉
            if(root.left==null){
                root=root.right;
            }
            else if(root.right==null){
                root=root.left;
            }
            else{
                binary_tree temp=root.right;
                root=root.left;
                binary_tree position_right=root;
                while(position_right.right!=null){
                    position_right=position_right.right;
                }
                position_right.right=temp;
            }
            // 要删除所有在区间内的数据，则要遍历完整棵树
            root=trimBST(root, low, high);
        }
        
        return root;
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
        trimBST(root_01, 3,4);
    }
}
