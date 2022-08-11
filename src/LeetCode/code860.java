// 贪心策略，尽量保留5的兑换
package LeetCode;

public class code860 {
    public static boolean lemonadeChange(int[] bills) {
        // 初始状态，5,10,15都为0
        int[] charge=new int[3];

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                charge[0]++;
            }
            else if(bills[i]==10){
                if(charge[0]>0){
                    charge[0]--;
                    charge[1]++;
                }
                else{
                    return false;
                }
            }
            else{
                if(charge[0]>0 && charge[1]>0){
                    charge[0]--;
                    charge[1]--;
                    charge[2]++;
                }
                else if(charge[0]>=3){
                    charge[0]=charge[0]-3;
                    charge[2]++;
                }
                else{
                    return false;
                }
            }
        }

        // 全部订单完成
        return true;
    }
    
    public static void main(String[] args){

        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
