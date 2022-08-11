package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class code78 {

    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {

        // 不同长度保证不会重复
        search_subsets(nums,0);      

        return result_lists;
    }

    public static void search_subsets(int[] nums,int number){
        List<Integer> temp_path=new ArrayList<>(path);
        result_lists.add(temp_path);

        for(int i=number;i<nums.length;i++){
            path.addLast(nums[i]);
            search_subsets(nums, i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        List<List<Integer>> result_lists=subsets(nums);
    } 
}
