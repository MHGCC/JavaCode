package LeetCode;
// 测试pull功能
// 测试branch,merge功能
// 测试近端、远端的影响
// 两个都是远端
// test/02，测试从远端pull文件后merge的冲突
// 本地修改，制造冲突
import javax.swing.text.Utilities;
import com.Ari.Arith;

// 发送到仓库分支，用于测试
import ;
import ;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class code1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] results=new int[2];
        Map<Integer,Integer> int_nums=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(int_nums.containsKey(target-nums[i])){
                results[0]=i;
                results[1]=int_nums.get(target-nums[i]);
            }
            else{
                int_nums.put(nums[i],i);
            }
        }
        return results; 
    }
    public static void main(String[] args){
        int[] nums={2,7,11,15};
        int target=9;
        System.out.print(Arrays.toString(twoSum(nums,target)));
    }
}
