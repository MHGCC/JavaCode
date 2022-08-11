// 以0作为重量，以1为价值？
// 从后向前遍历可以避免temp的使用，确实

package LeetCode;

import java.lang.Math;
import java.util.Arrays;

public class code474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] weights=get_weight_and_value(strs);

        int[][] result=new int[m+1][n+1];
        int[][] temp=new int[m+1][n+1];

        // 初始化
        result[0][0]=0;

        for(int i=0;i<strs.length;i++){
            temp=copy_2arrays(result);
            for(int x=weights[i][0];x<=m;x++){
                for(int y=weights[i][1];y<=n;y++){
                    result[x][y]=Math.max(temp[x][y],temp[x-weights[i][0]][y-weights[i][1]]+1);
                }
            }            
        }

        return result[m][n];
    }

    public static int[][] get_weight_and_value(String[] strs){
        int[][] weight_value=new int[strs.length][2];

        for(int i=0;i<strs.length;i++){
            int number=0;
            while(number<strs[i].length()){
                if(strs[i].charAt(number)=='0'){
                    weight_value[i][0]++;
                }
                else{
                    weight_value[i][1]++;
                }
                number++;
            }
        }

        return weight_value;
    }

    public static int[][] copy_2arrays(int[][] nums){
        int[][] temp=new int[nums.length][nums[0].length];

        for(int i=0;i<nums.length;i++){
            temp[i]=nums[i].clone();
        }

        return temp;
    }

    public static void main(String[] args){
        String[] nums={"10","0","1"};
        findMaxForm(nums,1,1);
    }
}
