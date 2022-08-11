// 这里思考组合剪枝
// n是会大于9的，但用于累积的数字范围为[1,9]
// 剪得比范例里多了

package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class code216 {

    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        // sum初始为0,起始值1的pre=0
        generate_path(k,n,0,0);

        return result_lists;
    }

    public static void generate_path(int k,int n,int sum,int pre){
        if(path.size()==k){
            // 后面有剪枝，所以这里不再再裁减一遍
            if(sum==n){
                List<Integer> temp_path=new ArrayList<>(path);
                result_lists.add(temp_path);
            }
        }
        else{
            int number=k-path.size();
            for(int i=pre+1;i<=Math.min((n-sum)/number,9);i++){
                path.addLast(i);
                generate_path(k, n, sum+i, i);
                path.removeLast();
            }
        }
    }


    public static void main(String[] args){
        int n=7;
        int k=3;
        List<List<Integer>> result_lists=combinationSum3(k,n);
    } 

}
