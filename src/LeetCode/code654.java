// 654题 先找最大数，然后递归，优化的话得考虑排序-map存储位置，但还是不是很适合，就直接查找吧

package LeetCode;

import tools.binary_tree;
import java.util.Arrays;

public class code654 {

    public static int search_max(int[] nums){
        int max_id=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[max_id]){
                max_id=i;
            }
        }
        return max_id;
    }

    public static binary_tree constructMaximumBinaryTree(int[] nums) {
        // 题给二叉树非空
        int position_root=search_max(nums);
        binary_tree root=new binary_tree(nums[position_root]);
        // 存在左子树
        if(position_root>0){
            root.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, position_root));
        }
        if(position_root+1<nums.length){
            root.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums, position_root+1, nums.length));;
        }        

        return root;
        
    }

    public static void main(String[] args){
        int[] nums={3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
    }

}
