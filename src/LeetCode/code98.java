// 第一次搞错了搜索二叉树的概念，不是左子和右子符合就行，而是要左树和右树符合
// 这里在迭代过程中尝试更新根节点max，min
// 更简单的，二叉搜索数的转换，判断数组有序即可
package LeetCode;

import tools.binary_tree;
import LeetCode.code94;
import java.util.List;

public class code98 {
    
    // 好像又是遍历问题
    public static boolean isValidBST(binary_tree root) {
        Boolean flag=true;
        // 直接进行中序遍历
        List<Integer> inorder_list=code94.inorderTraversal(root);
        for(int i=0;i<inorder_list.size()-1;i++){
            if(flag){
                if(inorder_list.get(i)>inorder_list.get(i+1)){
                    flag=false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(3);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(4);
        binary_tree leaf_03=new binary_tree(1);
        binary_tree leaf_04=new binary_tree(0);
        root_01.left=leaf_01;
        root_01.right=leaf_02;
        leaf_01.left=leaf_03;
        leaf_02.right=leaf_04;
        System.out.println(isValidBST(root_01));
    }
    
}
