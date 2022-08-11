// 拆分为质数，/2 获取的应该就是最大
// 因为质数的对大小不确定性（如8的2,2,2,2,和2,3,3），这题的时间复杂度O(n^2)了...
package LeetCode;

import java.lang.Math;

public class code343 {
    public static int integerBreak(int n) {
        if(n<=2){
            return 1;
        }
        else{
            int[] results=new int[n+1];

            results[2]=1;
            results[3]=2;
            // 对于加数中含1的，会出一些问题
            for(int i=4;i<=n;i++){
                int max=2*Math.max(i-2, results[i-2]);
                for(int j=3;j<=i/2;j++){
                    if(max<j*Math.max(i-j, results[i-j])){
                        max=j*Math.max(i-j, results[i-j]);
                    }
                }
                results[i]=max;
            }
            
            return results[n];
        }
    }
    public static void main(String[] args){
        System.out.println(integerBreak(8));
    }
}
