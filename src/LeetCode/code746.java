// 搞错了。 规则应该是这个： Once you pay the cost, you can either climb one or two steps.
// 仍然是cur的最优解只与cur-1和cur-2关联
// 还是要根据样例推演，cost
package LeetCode;

import java.lang.Math;

public class code746 {
    public static int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] step_cost=new int[n+2];
        step_cost[0]=cost[0];
        step_cost[1]=cost[1];
        for(int i=2;i<n;i++){
            step_cost[i] =Math.min(step_cost[i-1],step_cost[i-2])+cost[i];
        }
        
        // 到top的一步好像不需要cost
        return Math.min(step_cost[n-1],step_cost[n-2]);
    }

    public static void main(String[] args){
        // cost数组表示1,2,3级的花费
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
