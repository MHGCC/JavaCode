// 这题里给最多两次交易
// 考虑再加一个维记录交易次数？完整的一次交易包含买进卖出

package LeetCode;

public class code123 {
    public static int maxProfit(int[] prices) {

        // 增加一维，用于表示交易次数，0表示交易0次，1表示交易1次，2表示交易2次
        int[][][] result=new int[prices.length+1][2][3];
        // 初始化，[i][1][1]初始为0会影响到后面的判定
        for(int i=0;i<prices.length;i++){
            result[i][1][1]=Integer.MIN_VALUE;
        }

        // 0是不持有，1是持有.第一天不存在交易1,2次
        result[0][0][0]=0;
        result[0][1][0]=-prices[0];

        for(int i=1;i<prices.length;i++){
            // 对交易次数进行判定
            // 这次不进行交易
            result[i][0][0]=result[i-1][0][0];
            result[i][1][0]=Math.max(-prices[i], result[i-1][1][0]);

            // 1次交易
            result[i][0][1]=Math.max(result[i-1][1][0]+prices[i],result[i-1][0][1]);
            result[i][1][1]=Math.max(result[i-1][0][1]-prices[i],result[i-1][1][1]);

            // 2次交易,2次交易的买入在这里是没意义的
            if(result[i-1][1][1]!=Integer.MIN_VALUE){
                result[i][0][2]=Math.max(result[i-1][1][1]+prices[i],result[i-1][0][2]);
            }
            result[i][1][2]=Math.max(result[i-1][0][2]-prices[i],result[i-1][1][2]);                
        }

        int result_0=Math.max(result[prices.length-1][0][0],result[prices.length-1][1][0]+prices[prices.length-1]);
        // 这里也要控制必须先买进才能卖出
        int result_1=result[prices.length-1][0][1];
        if(result[prices.length-1][1][1]!=Integer.MIN_VALUE){
            result_1=Math.max(result_1,result[prices.length-1][1][1]+prices[prices.length-1]);
        }
        
        int result_return=Math.max(result_0,result_1);
        result_return=Math.max(result_return,result[prices.length-1][0][2]);

        return result_return;
    }

    public static void main(String[] args){
        int[] prices = {6,1,3,2,4,7};
        maxProfit(prices);
    } 
}
