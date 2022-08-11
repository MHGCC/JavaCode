package LeetCode;

import java.lang.Math;
import java.util.Arrays;

public class code279 {
    public static int numSquares(int n) {
        // 先打表得到数组
        int[] nums=get_nums(n);
        
        int[] result=new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0]=0;

        for(int i=1;i<nums.length;i++){
            for(int j=nums[i];j<=n;j++){
                result[j]=Math.min(result[j], result[j-nums[i]]+1);
            }
        }

        return result[n];
    }

    public static int[] get_nums(int n){
        int[] nums=new int[(int) Math.sqrt(n)+1];

        for(int i=1;i<=(int) Math.sqrt(n);i++){
            nums[i]=i*i;
        }

        return nums;
    }
    
    public static void main(String[] args){
        int n=13;
        numSquares(n);
    }
}
