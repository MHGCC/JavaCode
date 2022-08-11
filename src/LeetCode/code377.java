package LeetCode;

public class code377 {
    public static int combinationSum4(int[] nums, int target) {
        // 这里用滚动数组好了

        int[][] result=new int[nums.length][target+1];

        // 初始化,凑出0只有一种方案
          for(int i=0;i<nums.length;i++){
            result[i][0]=1;
        }
        
        /*
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=target;j++){
                // 排列,且有说明nums[i]各不相同
                result[i][j]=result[i-1][j];
                // nums[i] 填入的位置不同

            }
        }
        */

        // 一开始的想法是对的，以物品为外层循环，无法做到[1,2,3]，2在1之前的递推
        for(int j=1;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(i==0){
                    if(j>=nums[i]){
                        result[i][j]=result[nums.length-1][j-nums[i]];
                    } 
                    else{
                        result[i][j]=0;
                    }                   
                }
                else {
                    if(j>=nums[i]){
                        result[i][j]=result[i-1][j]+result[nums.length-1][j-nums[i]];
                    }
                    else{
                        result[i][j]=result[i-1][j];
                    }
                }
            }
        }

        return result[nums.length-1][target];
    }    

    public static void main(String[] args){
        int[] nums={1,2,3};
        combinationSum4(nums,4);
    }
}
