package LeetCode;

public class code518 {
    public static int change(int amount, int[] coins) {

        // 0值判定
        if(amount==0){
            return 1;
        }

        int[][] result=new int[coins.length][amount+1];
        // 初始化,凑出0只有一种方案
        for(int i=0;i<coins.length;i++){
            result[i][0]=1;
        }
        //[0][0]=1
        for(int i=0;i<=amount/coins[0];i++){
            result[0][i*coins[0]]=1;
        }

        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j<coins[i]){
                    result[i][j]=result[i-1][j];
                }
                else{
                    // 这种算法下，在[i][j-coints[i]]的结果中已包含[i-1][j-coins[i]]的结果，推一编就行
                    result[i][j]=result[i-1][j]+result[i][j-coins[i]];                    
                }
            }
        }

        return result[coins.length-1][amount];
    }
    
    public static void main(String[] args){
        int[] nums={1,2,5};
        change(500,nums);
    }
}
