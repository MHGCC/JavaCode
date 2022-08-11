// 因为是搜索二叉树，所以不用一个一个比
// 左右子树节点的差值必然小于其与根节点的差值
// 直接中序好了
package LeetCode;

import tools.binary_tree;
import java.lang.Math;
import LeetCode.code94;
import java.util.List;

public class code530 {

    public static int getMinimumDifference(binary_tree root) {
        // 至少有两个节点，不用判空树
        List<Integer> inorder_list=code94.inorderTraversal(root);
        int min=100001;
        for(int i=0;i<inorder_list.size()-1;i++){
            min=Math.min(min, Math.abs(inorder_list.get(i)-inorder_list.get(i+1)));
        }
        
        return min;
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
        System.out.println(getMinimumDifference(root_01));
    }
    
}
