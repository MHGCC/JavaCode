// 进行状态的递推
package LeetCode;

import java.lang.Math;

public class code133 {

    public static int maxProfit(int[] prices) {
        // 最大盈利状态,一天中只有买或者不买两种情况
        // 范例里只分持有和不持有
        int n=prices.length;
        int[][] profits=new int[n][2];

        // 初始状态（第1天),买入，持有，卖出，这样列举的就是动作了，错误
        // 状态是持有/不持有，动作是买入/卖出
        profits[0][0]=-prices[0];
        profits[0][1]=0;

        for(int i=1;i<n;i++){
            // 这个更新就很明确了1 第i天买入并持有股票第i-1天持有获益大（买入便宜）
            profits[i][0]=Math.max(profits[i-1][0],profits[i-1][1]-prices[i]);
            // 这个更新就很明确了1 第i天卖出并不持有股票第i-1天持有获益大（卖出贵）
            profits[i][1]=Math.max(profits[i-1][1],profits[i-1][0]+prices[i]);
        }

        return Math.max(profits[n-1][1],profits[n-1][0]+prices[n-1]);        
    }
    public static void main(String[] args){
        int[] prices={1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
