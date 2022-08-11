// 与 subsets 1 不同的是nums中存在重复的value，横向剪枝
// 看上去是有顺序的nums数组，事实上不是，先快排

package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import tools.q_sort_random;

public class code90 {

    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        
        q_sort_random sort_nums=new q_sort_random(nums);
        nums=sort_nums.nums;
        // 不同长度保证不会重复
        search_subsets(nums,0);      

        return result_lists;
    }

    public static void search_subsets(int[] nums,int number){
        List<Integer> temp_path=new ArrayList<>(path);
        result_lists.add(temp_path);

        for(int i=number;i<nums.length;i++){
            if(i==number || nums[i]!=nums[i-1]){
                path.addLast(nums[i]);
                search_subsets(nums, i+1);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,2};
        List<List<Integer>> result_lists=subsetsWithDup(nums);
    }
    
}
