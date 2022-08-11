// 递归的过程本身不能判断回文，所以需要另外的函数来判断
// 是切割，不是从里面找出回文。。。

package LeetCode;

import tools.q_sort_random;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class code131 {

    public static LinkedList<String> path=new LinkedList<>();
    public static List<List<String>> result_lists=new ArrayList<List<String>>();

    public static List<List<String>> partition(String s) {
        char[] char_s=s.toCharArray();
        get_palindrome(char_s);    
        
        return result_lists;
    }

    public static void get_palindrome(char[] s){
        // 这里尝试由子串的长度入手进行拆分
        for(int sub_length=1;sub_length<=s.length;sub_length++){
            int i=0;
            while(i+sub_length<=s.length){
                if(is_palindrome(Arrays.copyOfRange(s, i, i+sub_length))){
                    String temp_s=new String(Arrays.copyOfRange(s, i, i+sub_length));
                    path.add(temp_s);
                }
                i=i+sub_length;
            }
            // 清理一轮循环后可能生育的字符
            if(i<s.length){
                if(is_palindrome(Arrays.copyOfRange(s, i, s.length))){
                    String temp_s=new String(Arrays.copyOfRange(s, i, s.length));
                    path.add(temp_s);
                }                
            }
            if(path.size()!=0){
                List<String> temp_path=new ArrayList<>(path);
                result_lists.add(temp_path);
            }
            path.clear();
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
        String s="aab";
        List<List<String>> result_lists=partition(s);
    } 

}
