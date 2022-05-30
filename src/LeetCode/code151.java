package LeetCode;
import java.util.Arrays;

// 这题分两步，1 从String s 中提取出所有words 2 更换次序 给到一个新的String s。这是使用大量空间的做法
// 教程里的巧妙方法 1删去多余空格 2反转整个字符串 3反转单个words。写一下这个吧 

// 局部反转和全局反转的组合，很多题目都可以用这个思路
public class code151 {

    //这里考虑到
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

    public static char[] delete_space(char[] s) {
        // 去掉空格的规则，首部无空格，单词之间仅能有一个空格，结尾无空格
        // slow和fast的机制，保证slow_point之前的是需要保留的数组，fast_point是正在处理的位置
        // 若fast_point指向了保留元素，则与指向删去元素的slow交换
        int head=0;
        while((s[head]==' ')&&(head<s.length)){
            head=head+1;
        }
        //head指向非空格起点
        int tail=s.length-1;
        while((s[tail]==' ')&&(tail>-1)){
            tail=tail-1;
        }
        //tail指向非空格终点
        //字符串不全是空格
        int slow_point=head;
        if(head<=tail){     
            for(int fast_point=head;fast_point<=tail;fast_point++){
                if((s[fast_point]==' ')&&(s[fast_point+1]==' ')){
                    continue;
                }
                else{
                    s[slow_point]=s[fast_point];
                    slow_point=slow_point+1;
                }
            }
        }
        //slow_point之前的是保留位，所以这里截取到slow_point(不包括slow_point)
        return Arrays.copyOfRange(s, head, slow_point);
    }

    public static String reverseWords(String s) {
        char[] char_s=s.toCharArray();
        //1 快慢指针去多余空格
        char_s= delete_space(char_s);
        //全部reverse
        char_s=reverseString(char_s,0,char_s.length);
        //每一个word reverse
        int head_word=0;
        for(int tail_word=0;tail_word<char_s.length;tail_word++){
            if((head_word!=tail_word)&&(char_s[tail_word]==' ')){
                char_s=reverseString(char_s,head_word,tail_word);
                head_word=tail_word+1;
            }
        }
        char_s=reverseString(char_s,head_word,char_s.length);
        return String.valueOf(char_s);
    }

    public static void main(String[] args){
        //char[] str={'1','2','3'};
        String str="  123    56  7   ";
        reverseWords(str);
    }
}
