package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class code77 {

    public static List<List<Integer>> result_lists=new ArrayList<List<Integer>>();
    // 使用链表储存组合
    public static LinkedList<Integer> path_n_k=new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        generate_path(n,k,1);
        return result_lists;
    }

    public static void generate_path(int n,int k, int cur){
        if(path_n_k.size()==k){
            List<Integer> result_list=new ArrayList<>(path_n_k);
            result_lists.add(result_list);
        }
        else{
            for(int i=cur;i<=n;i++){
                path_n_k.add(i);
                generate_path(n, k, i+1);
                path_n_k.removeLast();
            }
        }
    }

    public static void main(String[] args){
        int n=1;
        int k=1;
        List<List<Integer>> result_lists=combine(n,k);
    } 

}
