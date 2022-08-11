// 这题不是很能想到动态规划的方法（因为是要找一个切入点。。）
// 贪心策略倒好像找到了

package LeetCode;

public class code134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        if(n==1){
            return 0;
        }
        else{
            int[] differences=new int[n];
            for(int i=0;i<n;i++){
                differences[i]=gas[i]-cost[i];
            }

            // 这样的话是O(n^2).wrong
            // 因为最多只转一圈，所以是O(n)
            int number=0;
            while(number<n){
                while(number<n && differences[number]<0){
                    number=number+1;
                }

                if(number==n-1 && differences[number]<0){
                    return -1;
                }

                int sum=differences[number];
                int head=number;
                int cur=(number+1)%n;
                while(sum+differences[cur]>=0 && cur!=head){
                    sum=sum+differences[cur];
                    cur=(cur+1)%n;
                }

                // 转了一圈
                if(cur==head){
                    return head;
                }

                // 已试探过所有可能性
                if(cur<head){
                    return -1;
                }

                number=cur+1;
            }

            return -1;

        }
    }

    public static void main(String[] args){
        int[] gas={5,0,9,4,3,3,9,9,1,2};
        int[] cost={6,7,5,9,5,8,7,1,10,5};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
