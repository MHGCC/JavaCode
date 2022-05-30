package LeetCode;
/*
    前一个844处理逻辑错误了。重来。
    s和t只包含小写字母（除#外）。从后向前检索字符串，建立一个'#'栈。
*/
public class code844_new {
    public static String backspaceDelete(String s){
        char[] s_char=s.toCharArray();
        int back_number=0;
        for(int fast_point=s_char.length-1;fast_point>=0;fast_point--){
            if(s_char[fast_point]=='#'){
                back_number=back_number+1;
            }
            else if(back_number>0){
                s_char[fast_point]='$';
                back_number=back_number-1;
            }
        }
        int slow_point=0;
        for(int fast_point=0;fast_point<s_char.length;fast_point++){
            //Java这个字符串索引真的难受，建议用字符数组好了。。。
            if((s_char[fast_point]!='#')&&(s_char[fast_point]!='$')){
                s_char[slow_point]=s_char[fast_point];
                slow_point=slow_point+1;
            }
        }
        return new String(s_char).substring(0, slow_point);
    }

    public static boolean backspaceCompare(String s, String t) {
        String s_delete=backspaceDelete(s);
        String t_delete=backspaceDelete(t);
        return s_delete.equals(t_delete);
    }
    public static void main(String[] args){
        //在Java中，字符串的创建还是用char[]数组好了，更明确
        //char[] s_char={'a','b','#','c'};
        //char[] t_char={'a','b','#','c'};
        String s="ab##";
        String t="c#d#";
        System.out.println(backspaceCompare(s, t));
    }
}
