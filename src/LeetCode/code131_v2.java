package LeetCode;

import tools.q_sort_random;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class code131_v2 {
    public static LinkedList<String> path=new LinkedList<>();
    public static List<List<String>> result_lists=new ArrayList<List<String>>();

    public static List<List<String>> partition(String s) {
        char[] char_s=s.toCharArray();
        get_palindrome(char_s,0);    
        
        return result_lists;
    }

    public static void get_palindrome(char[] s, int number){
        // 这里尝试由子串的长度入手进行拆分
        if(number==s.length){
            List<String> temp_path=new ArrayList<>(path);
            result_lists.add(temp_path);
        }
        else{
            for(int i=number;i<=s.length;i++){
                if(is_palindrome(Arrays.copyOfRange(s, number, i+1))){
                    String temp_s=new String(Arrays.copyOfRange(s, number, i+1));
                    path.addLast(temp_s);
                    get_palindrome(s, i+1);
                    path.removeLast();
                }
            }
        }
    }

    public static Boolean is_palindrome(char[] chars_s){
        int i=0;
        int j=chars_s.length-1;
        Boolean flag=true;
        while(i<j){
            if(chars_s[i]!=chars_s[j]){
                flag=false;
                break;
            }
            i=i+1;
            j=j-1;
        }

        return flag;

    }

    public static void main(String[] args){
        String s="abb";
        List<List<String>> result_lists=partition(s);
    }     
}
