package LeetCode;
// 这题用3个int作栈最省事
// 处理出错，有次序问题
class Solution {
    public static boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        char[] char_s=s.toCharArray();
        int stack_01=0;
        int stack_02=0;
        int stack_03=0;
        boolean flag_isValid=true;
        for(int i=0;i<char_s.length;i++){
            if(flag_isValid){
                switch(char_s[i]){
                    case '(':
                        stack_01=stack_01+1;
                        break;
                    case '[':
                        stack_02=stack_02+1;
                        break;  
                    case '{':
                        stack_03=stack_03+1;
                        break;
                    case ')':
                        if(stack_01>0){
                            stack_01=stack_01-1;
                        }               
                        else{
                            flag_isValid=false;
                        }
                        break;
                    case ']':
                        if(stack_02>0){
                            stack_02=stack_02-1;
                        }               
                        else{
                            flag_isValid=false;
                        }
                        break;
                    case '}':
                        if(stack_03>0){
                            stack_03=stack_03-1;
                        }               
                        else{
                            flag_isValid=false;
                        }
                        break;
                }
            }
        }
        if((stack_01==0)&&(stack_02==0)&&(stack_03==0)&&(flag_isValid)){
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