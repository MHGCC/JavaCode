package LeetCode;
// 说是字符串，但却给了一个char数组...
public class code344 {
    public static void reverseString(char[] s) {
        char temp;
        for(int i=0;i<s.length/2;i++){
            temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    }

    public static void main(){
        char[] str={'1','2','3'};
        //String str="Hello";
        reverseString(str);
    }
}
