package LeetCode;

import java.util.Arrays;

/*
    思路
    设置x,y坐标，以及给出一个走圈规则。
*/
public class code59 {
    public static int[][] generateMatrix(int n) {
        int arr[][]=new int[n+2][n+2];
        for(int i=0;i<n+2;i++){
            for(int j=0;j<n+2;j++){
                if((i!=0)&&(i!=n+1)&&(j!=0)&&(j!=n+1)){
                    arr[i][j]=0;
                }
                else{
                    arr[i][j]=-1;
                }
            }
        } 
        int x=1;
        int y=1;
        int flag=0;
        for(int i=1;i<=n*n;i++){
            arr[x][y]=i;
            switch(flag){
                case 0:
                    if(arr[x][y+1]!=0){
                        x=x+1;
                        flag=1;
                    }
                    else{
                        y=y+1;
                    }
                    break;
                case 1:
                    if(arr[x+1][y]!=0){
                        y=y-1;
                        flag=2;
                    }
                    else{
                        x=x+1;
                    }
                    break;
                case 2:
                    if(arr[x][y-1]!=0){
                        x=x-1;
                        flag=3;
                    }
                    else{
                        y=y-1;
                    }
                    break;
                case 3:
                    if(arr[x-1][y]!=0){
                        y=y+1;
                        flag=0;
                    }
                    else{
                        x=x-1;
                    }
                    break;
            }
        }
        int[][] arr_result=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr_result[i][j]=arr[i+1][j+1];
            }
        }
        return arr_result;
    } 
    public static void main(String[] args){
        int n=6;
        int[][] a=generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();   
        }
    }
}
