package LeetCode;

import java.lang.Math;
import java.util.Arrays;

public class code322 {
    public static int coinChange(int[] coins, int amount) {
        int[] result=new int[amount+1];

        Arrays.fill(result, -1);

        // 初始化,凑齐0元，用了0个硬币
        result[0]=0;

        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(result[j-coins[i]]!=-1){
                    if(result[j]!=-1){
                        result[j]=Math.min(result[j], result[j-coins[i]]+1);  
                    }
                    else{
                        result[j]=result[j-coins[i]]+1;
                    }                  
                }
            }
        }

        if(result[amount]!=-1){
            return result[amount];           
        }
        else{
            return -1;
        }
    }    

    public static void main(String[] args){
        int[] nums={1};
        coinChange(nums,0);
    }
}
