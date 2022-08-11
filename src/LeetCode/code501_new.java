package LeetCode;

import LeetCode.code94;
import java.util.List;
import tools.binary_tree;
import java.util.ArrayList;

public class code501_new{

    public static int[] findMode(binary_tree root) {
        // List<Integer> inorder_list=code94.inorderTraversal(root);
        int[] nums={-1,-1,-1,4,4,5,5,6,6};
        List<Integer> inorder_list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            inorder_list.add(nums[i]);
        }
        ArrayList<Integer> result_list=new ArrayList<>();
        int max_times=1;
        int times=1;
        for(int i=1;i<inorder_list.size();i++){
            if(inorder_list.get(i-1)==inorder_list.get(i)){
                times=times+1;
            }
            else{
                if(times>max_times){
                    max_times=times;
                }
                times=1;
            }
        }

        times=1;
        for(int i=1;i<inorder_list.size();i++){
            if(inorder_list.get(i-1)==inorder_list.get(i)){
                times=times+1;
            }
            else{
                if(times==max_times){
                    result_list.add(inorder_list.get(i-1));
                }
                times=1;
            }
        }

        if(times>max_times){
            // 清空result_list
            result_list.clear();
            result_list.add(inorder_list.get(inorder_list.size()-1));
            max_times=times;
        }
        else if(times==max_times){
            result_list.add(inorder_list.get(inorder_list.size()-1));
        }

        int[] result_int=new int[result_list.size()];
        for(int i=0;i<result_list.size();i++){
            result_int[i]=result_list.get(i);
        }

        return result_int;        
    }

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(3);
        binary_tree leaf_01=new binary_tree(3);
        binary_tree leaf_02=new binary_tree(4);
        binary_tree leaf_03=new binary_tree(1);
        binary_tree leaf_04=new binary_tree(4);
        root_01.left=leaf_01;
        root_01.right=leaf_02;
        leaf_01.left=leaf_03;
        leaf_02.right=leaf_04;
        System.out.println(findMode(root_01));
    }
}
