// 策略是使用尽量小的size满足greed
// 题给的g和s没有保证有序
package LeetCode;
import tools.q_sort_random;

public class code455 {
    public static int findContentChildren(int[] g, int[] s) {
        // 升序排序
        q_sort_random g_sort=new q_sort_random(g);
        q_sort_random s_sort=new q_sort_random(s);
        g=g_sort.nums;
        s=s_sort.nums;

        int number_greed=0;
        for(int i=0;i<s.length;i++){
            if(number_greed<g.length && g[number_greed]<=s[i]){
                number_greed=number_greed+1;
            }
        }

        return number_greed;

    } 

    public static void main(String[] args){
        int[] g={1,2};
        int[] s={1,2,3};
        System.out.println(findContentChildren(g, s));
    }
}
