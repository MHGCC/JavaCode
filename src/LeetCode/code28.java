package LeetCode;
import java.util.Arrays;
//这里看一下字符串检索子串的一些算法，算法导论相关章节32章
//这题只需要返回第一个匹配到的点就行
public class code28 {
    //写一个KMP算法

    //获取前缀数组pi
    public static int[] get_pi(char[] chars){
        int[] pi=new int[chars.length];
        //pi[0]必然为0
        pi[0]=-1;
        //从位置0开始匹配
        int q=-1;
        for(int p=1;p<chars.length;p++){
            //q>-1，不是从字符串首位开始回退，否则直接跳到比较语句（首位开始比较即最初状态）
            //不匹配，回退到记录的前缀位置，比较下一位，参考'ababaca'，pi[]={-1,-1,0,1,2,-1,0}
            //比较'c'时，chars[p]='c',chars[q+1]='b',(abab)，回退到q(当前为2）的前缀q=pi[2]=0,比较对象为chars[0+1]='b'，
            //若符合，则前缀pi[5]=1.
            while((q>-1)&&(chars[p]!=chars[q+1])){
                q=pi[q];
            }
            //if这里设置q=q+1，所以需要一个复位的过程
            if(chars[q+1]==chars[p]){
                q=q+1;
            }
            pi[p]=q;
        }
        return pi;
    }

    public static int strStr(String haystack, String needle) {
        int int_needle=-1;
        char[] needle_chars=needle.toCharArray();
        char[] haystack_chars=haystack.toCharArray();
        int m=needle_chars.length;
        int n=haystack_chars.length;
        int[] pi=get_pi(needle_chars);
        int q=-1;
        for(int p=0;p<n;p++){
            while((q>-1)&&(haystack_chars[p]!=needle_chars[q+1])){
                q=pi[q];
            }
            if(needle_chars[q+1]==haystack_chars[p]){
                q=q+1;
            }
            if(q==needle_chars.length-1){
                return p-m+1;
            }
        }
        return int_needle;
    }

    public static void main(String[] args){
        String haystack="aaaaa";
        String needle="bba";
        System.out.println(strStr(haystack,needle));
    }
}
