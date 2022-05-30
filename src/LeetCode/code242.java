package LeetCode;
//使用hash表解题，注意hash规模，小的可以用

public class code242 {
    public boolean isAnagram(String s, String t) {
        //都是小写字母
        int[] int_Anagram=new int[26];
        for(int i=0;i<int_Anagram.length;i++){
            int_Anagram[i]=0;
        }
        //转换为字符串数组
        for(char ch:s.toCharArray()){
            int_Anagram[ch-'a']=int_Anagram[ch-'a']+1;
        }
        for(char ch:t.toCharArray()){
            int_Anagram[ch-'a']=int_Anagram[ch-'a']-1;
        }

        for(int i=0;i<int_Anagram.length;i++){
        if(int_Anagram[i]!=0){
            return false;
        }
        }
        return true;
    } 
}
