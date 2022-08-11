// 检验推理过程
// 清理掉“处理最后一位”的过程,清理掉这一过程，仍然出错
// 问题在于我只在连续两位不一的情况下更新maxtimes
package LeetCode;

import LeetCode.code94;
import java.util.List;
import tools.binary_tree;
import java.util.ArrayList;

public class code501_v3 {

    public static int[] findMode(binary_tree root) {
        // List<Integer> inorder_list=code94.inorderTraversal(root);
        int[] nums={0,1};
        List<Integer> inorder_list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            inorder_list.add(nums[i]);
        }
        // 处理最后一位问题
        // inorder_list.add(inorder_list.get(inorder_list.size()-1)+1);

        ArrayList<Integer> result_list=new ArrayList<>();
        int max_times=0;
        int times=0;
        int pre=100001;
        for(int i=0;i<inorder_list.size();i++){
            if((i!=0)&&(pre==inorder_list.get(i))){
                times=times+1;
            }
            else{
                times=1;
            }

            if (i==0 || inorder_list.get(i) != pre) {
                times = 1;
            }else {
                times=times+1;
            }

            if (times > max_times) {
                max_times = times;
                result_list.clear();
                result_list.add(inorder_list.get(i));
            }
            else if (times==max_times) {
                result_list.add(inorder_list.get(i));
            }

            pre=inorder_list.get(i);
        }      
        
        int[] result_int=new int[result_list.size()];
        for(int i=0;i<result_list.size();i++){
            result_int[i]=result_list.get(i);
        }

        return result_int;        
    }

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(3);
        binary_tree leaf_01=new binary_tree(3);
        binary_tree leaf_02=new binary_tree(4);
        binary_tree leaf_03=new binary_tree(1);
        binary_tree leaf_04=new binary_tree(4);
        root_01.left=leaf_01;
        root_01.right=leaf_02;
        leaf_01.left=leaf_03;
        leaf_02.right=leaf_04;
        System.out.println(findMode(root_01));
    }
}
