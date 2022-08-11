package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class code51 {
    // 如果改为设置不可填入的位置，这里的position数组改为int数组
    static Boolean[][] position;
    static List<List<String>> results=new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        position=new Boolean[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(position[i], Boolean.FALSE);
        }

        // 按行递归,需要输出所有solution
        search_solution(0,n);

        return results;        
    }

    public static void search_solution(int number,int n){
        if(number==n){
            List<String> temp_result=generate_result(n);
            results.add(temp_result);
        }
        else{
            for(int i=0;i<n;i++){
                if(is_valid(number,i,n)){
                    position[number][i]=true;
                    search_solution(number+1, n);
                    position[number][i]=false;                    
                }
            }
        }
    }

    public static Boolean is_valid(int x,int y,int n){
        // 因为是逐行填入皇后的，所以只要
        // 同列
        int i=x-1;
        int y_left=y-1;
        int y_right=y+1;
        while(i>=0){
            if(position[i][y] || (y_left>=0 && position[i][y_left]) || (y_right<n && position[i][y_right])){
                return false;
            }
            i=i-1;
            y_left--;
            y_right++;
        }

        return true;
    }

    public static List<String> generate_result(int n){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++){
                if(position[i][j]){
                    s=s+'Q';
                }
                else{
                    s=s+'.';
                }
            }
            temp.add(s);
        }

        return temp;
    }
    
    public static void main(String[] args){
        int n=4;
        List<List<String>> result_lists=solveNQueens(n);
    } 
    
}
