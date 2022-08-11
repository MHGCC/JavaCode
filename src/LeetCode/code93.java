// 与131类似，其实也是个分割问题
// 相比而言，可以进行剪枝
// 可以在第四段字符生成上进行优化

package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class code93 {

    static List<String> result_list=new ArrayList<>();
    static LinkedList<String> path=new LinkedList<>();

    public static List<String> restoreIpAddresses(String s) {
        char[] chars_s=s.toCharArray();
        generate_IP(chars_s,0,0);

        return result_list;
    }

    public static void generate_IP(char[] s,int number,int ip_position){
        if(path.size()==4 && number==s.length){
            String temp="";
            for(int i=0;i<3;i++){
                temp=temp+path.get(i)+".";
            }
            temp=temp+path.get(3);
            result_list.add(temp);
        }
        else if(path.size()<4 && number<s.length){
            // i<3是迭代0,1,2
            for(int i=number;i<Math.min(number+3,s.length-(4-ip_position-1));i++){
                char[] address=Arrays.copyOfRange(s, number, i+1);
                if(is_valid(address)){
                    String temp=new String(address);
                    path.addLast(temp);
                    generate_IP(s,i+1,ip_position+1);
                    path.removeLast();
                }
            } 
        }
    }

    public static Boolean is_valid(char[] s){
        Boolean flag=true;
        if(s[0]=='0' && s.length>1){
            flag=false;
        }
        else{
            int sum=0;
            int i=0;
            while(i<s.length){
                sum=sum*10+(s[i]-'0');
                i=i+1;
            }
            if(sum>255){
                flag=false;
            }
        }
        return flag;
    }


    public static void main(String[] args){
        String s="101023";
        List<String> result_lists=restoreIpAddresses(s);
    }  

}
