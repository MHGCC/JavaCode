package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class code491 {

    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        search_subsequences(nums,0,-101);

        return result_lists;
    }

    public static void search_subsequences(int[] nums,int number,int pre){
        if(path.size()>=2){
            List<Integer> temp_path=new ArrayList<>(path);
            result_lists.add(temp_path);
        }

        // 判重对象。在递归的一层中，同一个值的nums[i]只能被使用一次
        int[] used=new int[201];

        for(int i=number;i<nums.length;i++){
            // 仍然需要在同一级中不使用相同值，避免重复path
            // 确实，这里因为没有排序所以相同的值并不会相邻，所以需要一个判重对象，
            // 题目中给出了 -100 <= nums[i] <= 100，也是一种提示
            if(used[nums[i]]==0 && nums[i]>=pre){
                used[nums[i]]=1;
                path.addLast(nums[i]);
                search_subsequences(nums, i+1, nums[i]);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        List<List<Integer>> result_lists=findSubsequences(nums);
    }
    
}
