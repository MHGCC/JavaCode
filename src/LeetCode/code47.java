package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class code47 {
    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();
    // 与46不同，这里的used 记录是使用的位置，因为有重复值
    public static int[] used_position;

    public static List<List<Integer>> permute(int[] nums) {
        used_position=new int[nums.length];
        generate_permute(nums,used_position);

        return result_lists;        
    }

    public static void generate_permute(int[] nums,int[] used_position) {
        if(path.size()==nums.length){
            List<Integer> temp_path=new ArrayList<>(path);
            result_lists.add(temp_path);
        }
        else{
            // 1 层之间位置不复用
            // 2 层内值不复用
            int [] used_value=new int[21];
            for(int i=0;i<nums.length;i++){
                if(used_position[i]==0 && used_value[nums[i]+10]==0){
                    used_position[i]=1;
                    used_value[nums[i]+10]=1;
                    path.addLast(nums[i]);
                    generate_permute(nums,used_position);
                    used_position[i]=0;
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
