package LeetCode;

import java.util.Stack;

public class code20_v2 {
    public static boolean isValid(String s) {
        char[] char_s=s.toCharArray();
        Stack<Character> stack_chars=new Stack<>();
        for(int i=0;i<char_s.length;i++){
            switch(char_s[i]){
                case '(':
                    stack_chars.push(char_s[i]);
                    break;
                case '[':
                    stack_chars.push(char_s[i]);
                    break; 
                case '{':
                    stack_chars.push(char_s[i]);
                    break;
                case ')':
                    if((!stack_chars.isEmpty())&&(stack_chars.peek()=='(')){
                        stack_chars.pop();
                    }               
                    else{
                        return false;
                    }
                    break;
                case ']':
                    if((!stack_chars.isEmpty())&&(stack_chars.peek()=='[')){
                        stack_chars.pop();
                    }               
                    else{
                        return false;
                    }
                    break;
                case '}':
                    if((!stack_chars.isEmpty())&&(stack_chars.peek()=='{')){
                        stack_chars.pop();
                    }               
                    else{
                        return false;
                    }
                    break;
            }
        }
        if(stack_chars.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args){
        String s="(([{)}])";
        System.out.println(isValid(s));
    }
}
