// 搞清楚 根据中序和后序还原二叉树的 原理
// 拆分步骤
/*
1 根据后序锁定根节点,记录根节点
2 根据 1 将中序分为两颗子树，后序按同样分配方式对应中序
3 将子树按照1,2继续分割

停止分割的条件是int[].size=0?
*/
package LeetCode;

import tools.binary_tree;
import java.util.Arrays;

public class code106 {
    
    public static int search_value(int[] nums,int key){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static binary_tree buildTree(int[] inorder, int[] postorder) {
        // 不占空间一点的话，其实可以用head,tail指示位置并作结束标记
        // 这棵树的节点至少为1
        // 节点的value唯一，不需要重复判定

        // 找到当前的根节点
        int root_value=postorder[postorder.length-1];
        binary_tree root=new binary_tree(root_value); 
        // Arrays.binarySearch需要数组有序
        // int position_root=Arrays.binarySearch(inorder, root_value);
        int position_root=search_value(inorder, root_value);
        //搜索左子树
        if(position_root-1>=0){
            root.left=buildTree(Arrays.copyOfRange(inorder, 0, position_root), 
            Arrays.copyOfRange(postorder, 0, position_root));
        }
        if(position_root<inorder.length-1){
            root.right=buildTree(Arrays.copyOfRange(inorder, position_root+1, inorder.length), 
            Arrays.copyOfRange(postorder, position_root, postorder.length-1));
        }
        return root;
    }

    public static void main(String[] args){
        int[] inorder={9,3,15,20,7};
        int[] postorder={9,15,7,20,3};
        buildTree(inorder,postorder);
    }
    
}
