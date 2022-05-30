package LeetCode;
// 在String s 中寻找 可以重新组合成s的子串
//以KMP算法的思路想一想。前缀数组循环，不过不一定是找最长前缀
//如果一个子串能循环构成整个原字符串，那么前缀数组不会中断
//画图加归纳法可以证明，L=s.length-(pi[s.length-1]-0+1)即原字符串长度-最大前后缀长度=L
//若可以被s.length整除，则s可被S0重复构成(S0是s前L个字符组成的子串)
public class code459 {
    public static boolean repeatedSubstringPattern(String s) {
        char[] chars_s=s.toCharArray();
        int N=chars_s.length;
        int[] pi=new int[N];
        pi[0]=-1;
        int q=-1;
        for(int p=1;p<N;p++){
            while((q>-1)&&(chars_s[q+1]!=chars_s[p])){
                q=pi[q];
            }
            if(chars_s[q+1]==chars_s[p]){
                q=q+1;
            }
            pi[p]=q;
        }
        if(((pi[N-1]-0+1)!=0)&&(N%(N-(pi[N-1]-0+1))==0)){
            return true;
        } 
        else{
            return false;
        }
    }  
    public static void main(String[] args){
        String haystack="abac";
        System.out.println(repeatedSubstringPattern(haystack));
    }  
}
