// 这题两两相撞，其实也就是分成重量最接近的两堆互撞（感觉不太直观，但没想到反例）
package LeetCode;

import java.util.Arrays;

public class code1049 {
    public static int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i=0;i<stones.length;i++){
            sum=sum+stones[i];
        }

        // 求两堆重量最相近的，求出小于等于一半的最大堆即可
        int n=stones.length;
        int box_length=sum/2;
        int[] box=new int[box_length+1];
        int[] box_temp=new int[box_length+1];

        for(int i=0;i<=box_length;i++){
            if(i>=stones[0]){
                box[i]=stones[0];
            }
        }

        // 01背包，石头不能复用，用box_temp解决
        // 范例中使用物品作为外层来避免复用的问题，也是一种思路
        for(int i=1;i<n;i++){
            box_temp=Arrays.copyOf(box, box_length+1);
            for(int j=stones[i];j<=box_length;j++){
                box[j]=Math.max(box_temp[j],box_temp[j-stones[i]]+stones[i]);
            }
        }

        return sum-2*box[box_length];            
    }     

    public static void main(String[] args){
        int[] stones={31,26,33,21,40};
        lastStoneWeightII(stones);
        
    }
}
