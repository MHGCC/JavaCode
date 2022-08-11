package LeetCode;

import java.util.List;

import tools.TreeNode;
import java.util.ArrayList;

public class code102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results=new ArrayList<List<Integer>>();
        if(root!=null){
            // 嵌套List，最外层list1操作的对象是内层list<Integer>
            // List.get(i),获取i位置的对象
            int deep=0;
            List<Integer> result_deep=new ArrayList<>();
            result_deep.add(root.value);
            results.add(result_deep);
            search_level(root, deep, results);
            return results;
        }
        else{
            return results;
        }
    }

    public static void search_level(TreeNode root,int deep,List<List<Integer>> results){
        if(root!=null){
            deep=deep+1;
            if(root.left!=null){
                if(results.size()<=deep){
                    List<Integer> result_deep=new ArrayList<>();
                    result_deep.add(root.left.value);
                    results.add(result_deep);
                }
                else{
                    results.get(deep).add(root.left.value);
                }
                search_level(root.left, deep, results);
            }
            if(root.right!=null){
                if(results.size()<=deep){
                    List<Integer> result_deep=new ArrayList<>();
                    result_deep.add(root.right.value);
                    results.add(result_deep);
                }
                else{
                    results.get(deep).add(root.right.value);
                }
                search_level(root.right, deep, results);
            }
        }
    }
    public static void main(String[] args){
        TreeNode root_01=new TreeNode(1);
        TreeNode leaf_01=new TreeNode(2);
        TreeNode leaf_02=new TreeNode(3);
        root_01.right=leaf_01;
        leaf_01.left=leaf_02;
        levelOrder(root_01);
    } 
}
