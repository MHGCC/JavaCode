// 前序和中序构造二叉树，寻找根节点和拆分方式不同

package LeetCode;

import tools.binary_tree;
import java.util.Arrays;

public class code105 {

    public static int search_value(int[] nums,int key){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static binary_tree buildTree(int[] preorder, int[] inorder) {
        // 这棵树的节点至少为1
        // 节点的value唯一，不需要重复判定

        // 找到当前的根节点
        int root_value=preorder[0];
        binary_tree root=new binary_tree(root_value); 
        // Arrays.binarySearch需要数组有序
        // int position_root=Arrays.binarySearch(inorder, root_value);
        int position_root=search_value(inorder, root_value);
        //搜索左子树
        if(position_root-1>=0){
            root.left=buildTree(Arrays.copyOfRange(preorder, 1, position_root+1), 
            Arrays.copyOfRange(inorder, 0, position_root));
        }
        if(position_root<inorder.length-1){
            root.right=buildTree(Arrays.copyOfRange(preorder, position_root+1, preorder.length), 
            Arrays.copyOfRange(inorder, position_root+1, inorder.length));
        }
        return root;
    }

    public static void main(String[] args){
        int[] inorder={9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};
        buildTree(preorder,inorder);
    }
    
}
