// 递推的规则比较明确
package LeetCode;

public class code62 {
    public static int uniquePaths(int m, int n) {
        int[][] path=new int[m][n];
        // 初始化，left和top边上的路径都只有一条
        for(int i=0;i<m;i++){
            path[i][0]=1;
        }
        for(int i=0;i<n;i++){
            path[0][i]=1;
        }
        // path[x][y]只与path[x-1][y]和path[x][y-1]有关，因此可以按行-按列递推
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                path[i][j]=path[i-1][j]+path[i][j-1];
            }
        }

        return path[m-1][n-1];
    }    

    public static void main(String[] args){

        System.out.println(uniquePaths(3, 2));
    }
}
