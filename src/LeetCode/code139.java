// 这里的问题是怎么转换到背包问题上
// 不要想由子集组成s，而是把s切割成各部分，在dict中是否能找出对应部分

package LeetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class code139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // result数组的含义是 result[i]=true,则s的前i个字符组成的子集可由dict中的字符串组成
        Boolean[] result=new Boolean[s.length()+1];

        Arrays.fill(result, false);

        // 初始化
        result[0]=true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<wordDict.size();j++){
                // 只求一种解法
                if(!result[i] && i>=wordDict.get(j).length()){
                    result[i]=(s.substring(i-wordDict.get(j).length(), i).equals(wordDict.get(j)) & result[i-wordDict.get(j).length()]);
                }
            }
        }

        return result[s.length()];
    }

    public static void main(String[] args){
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");        
        wordBreak(s,wordDict);
    }
}
