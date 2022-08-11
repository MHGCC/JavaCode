// 这题好像想不到动规。因为不能由i-1状态推i状态（一个小朋友的糖果数是与相邻两个小朋友相关的）
// 贪心策略肯定是能给小的就尽量给小的
package LeetCode;

public class code135 {
    public static int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
        // 必然要给1块饼干
        candies[0]=1;
        for(int i=1;i<n;i++){
            // 首先只考虑正向
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
            else{
                candies[i]=1;
            }
        }

        for(int i=n-2;i>=0;i--){
            // 在正向的基础上再修改
            if(ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]){
                candies[i]=candies[i+1]+1;
            }
        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+candies[i];
        }

        return sum;
    }

    public static void main(String[] args){
        int[] ratings = {1,0,2};

        System.out.println(candy(ratings));
    }
}
