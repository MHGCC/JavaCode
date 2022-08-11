package LeetCode;

import java.lang.Math;
import java.util.Arrays;
public class code45 {
    public static int jump(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        else{
            int[] path=new int[n+1];
            Arrays.fill(path,-1);
            path[0]=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<=Math.min(i+nums[i], n);j++){
                    if(path[j]==-1 || path[i]+1<path[j]){
                        path[j]=path[i]+1;
                    }
                }
            }

            return path[n-1];
        }

    } 
    
    public static void main(String[] args){
        int[] prices={0};
        System.out.println(jump(prices));
    }
}
