package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class code17 {
    // 首先得打个表
    public static final String[] digitals_to_chars={
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public static List<String> result_lists=new ArrayList<>();
    public static String low_chars="";

    public static List<String> letterCombinations(String digits) {
        if(digits.length()>0){
            convert_digits(digits,0);
        }
        return result_lists;
    }

    public static void convert_digits(String digits,int number){
        if(number==digits.length()){
            result_lists.add(low_chars);
        }
        else{
            for(int i=0;i<digitals_to_chars[(digits.charAt(number)-'0')].length();i++){
                low_chars=low_chars+digitals_to_chars[(digits.charAt(number)-'0')].charAt(i);
                convert_digits(digits, number+1);
                low_chars = low_chars.substring(0, low_chars.length()-1);
            }
        }
    }

    public static void main(String[] args){
        String digits="23";
        List<String> result_lists=letterCombinations(digits);
    } 

}
