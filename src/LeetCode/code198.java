// 这题里只给一次交易
// 始终记录最低的股价，然后计算每一天卖出的最大收益

package LeetCode;

import java.lang.Math;

public class code198 {
    public static int maxProfit(int[] prices) {

        int[][] result=new int[prices.length+1][2];

        // 0是不持有，1是持有
        result[0][0]=0;
        result[0][1]=-prices[0];

        for(int i=1;i<prices.length;i++){
            result[i][0]=Math.max(result[i-1][1]+prices[i],result[i-1][0]);
            result[i][1]=Math.max(0-prices[i],result[i-1][1]);
        }

        return Math.max(result[prices.length-1][0],result[prices.length-1][1]+prices[prices.length-1]);
        
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        maxProfit(prices);
    }
}
