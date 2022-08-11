// 先假定有序吧
// 范例中的剪枝是在for这一步判断是否会大于target，比我的少进了几次for循环和下一个递归的if

package LeetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class code39 {

    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        search_results(candidates,target,0,0);
        return result_lists;
    }

    public static void search_results(int[] candidates,int target,int sum,int number){
        if(sum==target){
            List<Integer> result=new ArrayList<>(path);
            result_lists.add(result);
        }
        else if(sum<target){
            for(int i=number;i<candidates.length;i++){
                path.addLast(candidates[i]);
                search_results(candidates, target, sum+candidates[i],i);
                path.removeLast();
            }
        }
    }
    
    public static void main(String[] args){
        int[] candidates={2,3,6,7};
        int k=7;
        List<List<Integer>> result_lists=combinationSum(candidates,k);
    } 
}
