// 爬楼梯也是入门级的动规，1<=n<=45
package LeetCode;

public class code70 {
    public static int climbStairs(int n) {
        int[] climb_approaches=new int[n+1];
        if(n<=1){
            return 1;
        }
        climb_approaches[1]=1;
        climb_approaches[2]=2;
        for(int i=3;i<=n;i++){
            climb_approaches[i]=climb_approaches[i-1]+climb_approaches[i-2];
        }

        return climb_approaches[n];
    }
    
    public static void main(String[] args){
        int n=8;
        System.out.println(climbStairs(n));
    }
}
