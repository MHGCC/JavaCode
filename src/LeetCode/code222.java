// 统计节点数其实也就是遍历问题，要求时间复杂度O(n)，递归或迭代都行

package LeetCode;

import tools.binary_tree;

public class code222 {
    public static int countNodes(binary_tree root) {
        if(root==null){
            return 0;
        }
        else{
            int count_left=countNodes(root.left);
            int count_right=countNodes(root.right);
            return 1+count_left+count_right;
        }
    }

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(1);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(3);
        binary_tree leaf_03=new binary_tree(4);
        binary_tree leaf_04=new binary_tree(5);
        root_01.right=leaf_01;
        root_01.left=leaf_02;
        leaf_01.left=leaf_03;
        leaf_02.right=leaf_04;
        System.out.println(countNodes(root_01));
    } 
}
