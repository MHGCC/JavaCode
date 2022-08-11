package LeetCode;

import tools.q_sort_random;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class code40 {

    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        q_sort_random object_sort=new q_sort_random(candidates);
        generate_results(object_sort.nums,target,0,0);
        return result_lists;
    }

    public static void generate_results(int[] candidates,int target,int number,int sum){
        if(sum==target){
            List<Integer> temp_path=new ArrayList<>(path);
            result_lists.add(temp_path);
        }
        else{
            for(int i=number;i<candidates.length;i++){
                // 这里对重复值进行一次处理，两个/多个重复值只有在不同深度的迭代中会被装入用一批次的path中，
                if(i==number || candidates[i]!=candidates[i-1]){
                    // break跳出循环
                    if(sum+candidates[i]>target){
                        break;
                    }
                    else{
                        path.addLast(candidates[i]);
                        generate_results(candidates, target, i+1, sum+candidates[i]);
                        path.removeLast();
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> result_lists=combinationSum2(candidates,target);
    } 

}
