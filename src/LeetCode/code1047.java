//使用栈很容易实现相邻元素的比较，包括删除部分元素后变得相邻的元素的继续比较
//可以用一个新的字符串替代栈
package LeetCode;
import java.util.Stack;

public class code1047 {
    public static String removeDuplicates(String s) {
        char[] char_s=s.toCharArray();
        Stack<Character> stack_chars=new Stack<>();  
        for(int i=0;i<char_s.length;i++){
            if(!stack_chars.isEmpty()){
                if(stack_chars.peek()==char_s[i]){
                    stack_chars.pop();
                }
                else{
                    stack_chars.push(char_s[i]);
                }
            }
            else{
                stack_chars.push(char_s[i]);
            }
        }
        String result_s="";
        while(!stack_chars.isEmpty()){
            result_s=stack_chars.pop()+result_s;
        }
        return result_s;
    }

    public static void main(String[] args){
        String s="azxxzy";
        System.out.println(removeDuplicates(s));
    }
}
