package LeetCode;

public class code541 {
    public static char[] reverseString(char[] s,int head,int tail) {
        char temp;
        int length=tail-head;
        for(int i=0;i<length/2;i++){
            temp=s[head+i];
            s[head+i]=s[head+length-1-i];
            s[head+length-1-i]=temp;
        }
        return s;
    }

    public static String reverseStr(String s, int k) {
        char[] char_result=s.toCharArray();
        int length_s=s.length();
        int i=0;
        for(i=0;i<length_s/(2*k);i++){
            char_result=reverseString(char_result,i*2*k,i*2*k+k);
        }
        //加一次判定，解决题目中的问题
        if((i*2*k+k<=length_s)&&((i+1)*2*k>length_s)){
            char_result=reverseString(char_result,i*2*k,i*2*k+k);
        }
        else{
            char_result=reverseString(char_result,i*2*k,s.length());
        }
        s=String.valueOf(char_result);
        return s;
    }    

    public static void main(String[] args){
        //char[] str={'1','2','3'};
        String str="abcdefg";
        reverseStr(str,8);
    }
}
