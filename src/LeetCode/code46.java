package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class code46 {

    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();
    public static int[] used=new int[21];

    public static List<List<Integer>> permute(int[] nums) {
        generate_permute(nums);

        return result_lists;        
    }

    public static void generate_permute(int[] nums) {
        if(path.size()==nums.length){
            List<Integer> temp_path=new ArrayList<>(path);
            result_lists.add(temp_path);
        }
        else{
            // 这里是需要不同层之间的nums[i] 不重复使用
            for(int i=0;i<nums.length;i++){
                if(used[nums[i]+10]==0){
                    used[nums[i]+10]=1;
                    path.addLast(nums[i]);
                    generate_permute(nums);
                    used[nums[i]+10]=0;
                    path.removeLast();
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        List<List<Integer>> result_lists=permute(nums);
    }
    
}
