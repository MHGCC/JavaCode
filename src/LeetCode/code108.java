package LeetCode;

import tools.binary_tree;
import java.util.Arrays;

public class code108 {
    public static binary_tree sortedArrayToBST(int[] nums) {
        // 不会给出空数组
        // 不断切分就可以了
        if(nums.length<=1){
            if(nums.length==1){
                binary_tree root=new binary_tree(nums[0]);
                return root;
            }
            else{
                return null;
            }
        }
        else{
            int middle=nums.length/2;
            binary_tree root=new binary_tree(nums[middle]);
            root.left=sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
            root.right=sortedArrayToBST(Arrays.copyOfRange(nums, middle+1, nums.length));                
            return root;
        }
        
    }

    public static void main(String[] args){
        int[] nums={-10,-3,0,5,9};
        binary_tree root =sortedArrayToBST(nums);
    }
}
