package LeetCode;

public class code383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //26个字母Hash
        int[] nums_char=new int[26];
        for(int i=0;i<26;i++){
            nums_char[i]=0;
        }
        char[] chars_ransomNote=ransomNote.toCharArray();
        char[] chars_magazine=magazine.toCharArray();
        for(char ch:chars_ransomNote){
            nums_char[ch-'a']=nums_char[ch-'a']+1;
        }
        for(char ch:chars_magazine){
            nums_char[ch-'a']=nums_char[ch-'a']-1;
        }        
        for(int i=0;i<26;i++){
            if(nums_char[i]>0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String ransomNote="aa";
        String magazine="abaa";
        canConstruct(ransomNote,magazine);
    }
}
