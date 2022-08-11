package LeetCode;

import java.util.Arrays;
import java.lang.Math;

public class code494 {

    public static int findTargetSumWays(int[] nums, int target) {

        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        // 克服负数，以sum为0;
        int[][] result=new int[n][2*sum+1];
        // 使用任何数计算得到0的式子为0个
        for(int i=0;i<n;i++){
            result[i][sum]=0;
        }

        result[0][sum+nums[0]]=1;
        result[0][sum-nums[0]]=1;


        for(int i=1;i<n;i++){
            for(int j=0;j<=2*sum;j++){
                if(j>=nums[i]){
                    result[i][j]=result[i][j]+result[i-1][j-nums[i]];
                }
                if(j+nums[i]<=2*sum){
                    result[i][j]=result[i][j]+result[i-1][j+nums[i]];
                }
            }
        }

        return result[n-1][sum+target];

    }
    
    public static void main(String[] args){
        int[] nums={1,1,1,1,1};
        findTargetSumWays(nums,3);
    }
}
