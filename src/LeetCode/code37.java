// 确实，一行一行的递归存在问题，不能在上一行没有填充完的情况下对下一行的填充内容进行穷举

package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class code37 {

    static int[][] position;

    public static void solveSudoku(char[][] board) {
        // 初始化positions数组
        get_ints(board);
        // 开始递归，以行为索引
        get_solution(position);
        // 看了一下，只要最后调整board就行
        generate_new_board(board);
    }

    public static void get_ints(char[][] board){
        position=new int[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    position[i][j]=0;
                }
                else{
                    position[i][j]=board[i][j]-'0';
                }
            }
        }
    }

    public static Boolean get_solution(int[][] position){
        // 自上而下，自左而右，填充第一个未填充数字的格子
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                // 未填充
                if(position[i][j]==0){
                    for(int k=1;k<10;k++){
                        if(is_valid(i,j,k)){
                            position[i][j]=k;
                            if(get_solution(position)){
                                // break不太够用，题给要求只需要一个解，那直接return 
                                return true;
                            }
                            position[i][j]=0;
                        }
                    }

                    // 9个数试完，还没true，那这一格得回溯再填，则返回false
                    return false;
                }
            }
        }
        // 格子填充完毕，则找到一个解
        return true;
    }

    public static Boolean is_valid(int x,int y,int value){
        for(int i=0;i<9;i++){
            if(position[x][i]==value){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(position[i][y]==value){
                return false;
            }
        }
        // 9宫格判断
        int x_v1=x/3;
        int y_v1=y/3;
        for(int i=3*x_v1;i<3*(x_v1+1);i++){
            for(int j=3*y_v1;j<3*(y_v1+1);j++){
                if(position[i][j]==value){
                    return false;
                }
            }
        }

        return true;
    }

    public static void generate_new_board(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=(char) (position[i][j]+48);
            }
        }
    }

    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);
    }

}
