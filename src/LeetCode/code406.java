// 不能确定初始状态，好像也不能动规。
// 先按降序排序，然后按最大的为基点放入格子中

// 范例里是一种插入法，比我这个巧妙
package LeetCode;

import LeetCode.code406_sort;

public class code406 {
    public static int[][] reconstructQueue(int[][] people) {
        code406_sort people_sort=new code406_sort(people);
        people=people_sort.nums;

        int[][] result=new int[people.length][people[0].length];

        for(int i=0;i<people.length;i++){
            result[i][0]=-1;
        }

        // 开始填充
        // 
        int fill_position=0;
        int n=people.length;
        for(int i=0;i<n;i++){
            int number=0;
            // 跳过已填充的
            while(result[fill_position][0]!=-1){
                fill_position++;
            }

            // 确定填充位置
            for(int j=fill_position;j<n;j++){
                if(result[j][0]==-1 && number==people[i][1]){
                    result[j][0]=people[i][0];
                    result[j][1]=people[i][1];
                    break;
                }
                else{
                    if(result[j][0]==-1){
                        number++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
    }
}
