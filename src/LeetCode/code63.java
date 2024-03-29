package LeetCode;

public class code63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] path=new int[m][n];
        // 初始化，left和top边上的路径都只有一条
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                path[i][0]=1;
            }
            else{
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]!=1){
                path[0][i]=1;
            }
            else{
                break;
            }
        }
        // path[x][y]只与path[x-1][y]和path[x][y-1]有关，因此可以按行-按列递推
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1){
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }
            }
        }

        return path[m-1][n-1];
    }    

    public static void main(String[] args){
        int[][] obstacleGrid={{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
