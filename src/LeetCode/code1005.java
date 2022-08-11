// 这题的策略很简单
package LeetCode;

import tools.q_sort_random;
import java.lang.Math;

public class code1005 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        q_sort_random nums_sort_object=new q_sort_random(nums);
        nums=nums_sort_object.nums;

        int sum=0;
        int number=0;
        while(number<nums.length && nums[number]<0 && k>0){
            nums[number]=-nums[number];
            number=number+1;
            k=k-1;
        }

        nums_sort_object=new q_sort_random(nums);
        nums=nums_sort_object.nums;        

        while(k>0){
            nums[0]=-nums[0];
            k=k-1;
        }

        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }


        return sum;
    }

    public static void main(String[] args){
        int[] nums={-8,3,-5,-3,-5,-2};
        int k=6;
        System.out.println(largestSumAfterKNegations(nums,k));
    }
}
