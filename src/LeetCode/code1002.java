package LeetCode;

import java.util.ArrayList;
import java.util.List;

//仍然可以用数组解决
//这个hash问题里每个数组只有第一次出现计数有效
//这里只需要记录每个String中字母出现的最小值就行，还不用搞数组链表
public class code1002 {
    public static List<String> commonChars(String[] words) {
        int[] int_Anagram=new int[26];
        for(int i=0;i<int_Anagram.length;i++){
            int_Anagram[i]=0;
        }
        int String_number=words.length;
        for(int i=0;i<String_number;i++){
            String String_temp=words[i];
            int[] int_temp=new int[26];
            for(int j=0;j<int_temp.length;j++){
                int_temp[j]=0;
            }
            for(char ch:String_temp.toCharArray()){
                int_temp[ch-'a']=int_temp[ch-'a']+1;
            }
            for(int j=0;j<int_temp.length;j++){
                if(i==0){
                    int_Anagram[j]=int_temp[j];
                }
                else if(int_Anagram[j]!=0){
                    if(int_temp[j]<=int_Anagram[j]){
                        int_Anagram[j]=int_temp[j];
                    }
                }
            }
        }     
        //用arrayList初始化
        List<String> Strings_return=new ArrayList<String>();
        for(int i=0;i<int_Anagram.length;i++){
            if(int_Anagram[i]>0){
                //ascii码字符
                for(int j=0;j<int_Anagram[i];j++){
                    Strings_return.add(Character.toString((char)('a'+i)));
                }
            }
        }
        return Strings_return;
    }

    public static void main(String[] args){
        String[] words = {"cool","lock","cook"};
        List<String> String_results=commonChars(words);
    }
}
