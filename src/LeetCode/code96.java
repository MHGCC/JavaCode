// 得由小数总结规律，递推到大数
// 这题可以以新增的节点node[n]为分界点，把所有节点分为两部分[是node[n]的根节点/上级节点]，[是node[n]的子节点],两部分分别对应一个小规模（因为是BTS）
package LeetCode;

public class code96 {

    public static int numTrees(int n) {
        if(n==1){
            return 1;
        }
        else{
            int[] results=new int[n+1];
            results[0]=1;
            results[1]=1;
            results[2]=2;
            for(int i=3;i<=n;i++){
                results[i]=0;
                for(int j=0;j<i;j++){
                    results[i]=results[i]+results[j]*results[i-j-1];
                }
            }

            return results[n];
        }      
    }
    public static void main(String[] args){
        System.out.println(numTrees(4));
    }
}
