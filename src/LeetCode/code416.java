// 这个想法确实有点意思，凡是使用给定的集合元素的组合去达到某个值，都可以转化为装箱问题
// 这里把集合分为两个子集，验证两个子集的值是否能相等
// 可以转化为:先求集合的值和sum，以sum/2为箱子容积，验证是否有子集{value作为weight,value作为value}能装入这个箱子

package LeetCode;

import java.lang.Math;

public class code416 {
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }

        if(sum/2==(sum-sum/2)){
            int n=nums.length;
            int box_length=sum/2;
            int[][] box=new int[n][box_length+1];

            for(int i=0;i<=box_length;i++){
                if(i>=nums[0]){
                    box[0][i]=nums[0];
                }
            }

            for(int i=1;i<n;i++){
                for(int j=0;j<=box_length;j++){
                    if(j>=nums[i]){
                        box[i][j]=Math.max(box[i-1][j],box[i-1][j-nums[i]]+nums[i]);
                    }
                    else{
                        box[i][j]=box[i-1][j];
                    }
                }
            }

            if(box[n-1][box_length]==box_length){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }    

    public static void main(String[] args){
        int[] nums={1,5,10,6};
        canPartition(nums);
        
    }
}
