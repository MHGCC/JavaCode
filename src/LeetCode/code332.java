/*
 * 理一下思路
 * 递归的起点是JFK，1 数据预处理，根据给出的tickets构建n*n的数组，按字母顺序排布，保证第一轮找到时就是所需的路径
 * 2 递归结束，path.length==n
 * 需要注意 相同两个城市之间可能不止一张ticket
 */

package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.Math;

public class code332 {

    public static LinkedList<String> path=new LinkedList<>();
    public static List<String> result;
    public static int[][] cities;
    public static String[] city_names;
    public static Map<String,Integer> names_number=new HashMap<>();

    public static List<String> findItinerary(List<List<String>> tickets) {
        // 提取有序的城市名称
        get_city_names(tickets);
        // 生成城市间的tickets情况
        generate_cities(tickets);
        // 开始递归,初始tickets使用为0，起点为JFK
        path.add("JFK");
        search_result(0,names_number.get("JFK"),tickets);


        return result;
    }

    public static void get_city_names(List<List<String>> tickets){
        int number=-1;
        // 循环结束，map中已包含所有不重复的city_names
        for(int i=0;i<tickets.size();i++){
            for(int j=0;j<tickets.get(i).size();j++){
                if(!names_number.containsKey(tickets.get(i).get(j))){
                    number=number+1;
                    names_number.put(tickets.get(i).get(j),number);
                }
            }
        }
        // 有方便的函数可以完成Key转换为数组这一步
        // 同时完成对字符串的排序
        city_names = sort_names(names_number.keySet().toArray(new String[0]));
        // 按字典顺序，重置map的value
        int length=names_number.size();
        for(int i=0;i<length;i++){
            // 直接map.put()就可以更新
            names_number.put(city_names[i],i);
        }
    }

    public static void generate_cities(List<List<String>> tickets){
        // Boolean new初始化都是false
        cities=new int[city_names.length][city_names.length];
        // 也可通过Arrays.fill(Array,Boolean.False) 进行赋值,但fill只适合一维数组
        for(int i=0;i<cities.length;i++){
            Arrays.fill(cities[i],0);
        }
        
        int number=0;
        for(int i=0;i<tickets.size();i++){
            number=number+1;
            cities[names_number.get(tickets.get(i).get(0))][names_number.get(tickets.get(i).get(1))]++;
        }        
        System.out.println(number);
    }

    public static String[] sort_names(String[] names){
        String temp;
        for(int i=0;i<names.length-1;i++){
            for(int j=i+1;j<names.length;j++){
                if(names[i].compareTo(names[j])>0){
                    temp=names[i];
                    names[i]=names[j];
                    names[j]=temp;
                }
            }
        }

        return names;
    }

    public static void search_result(int number,int pre,List<List<String>> tickets){
        // 找到一条路径，且由于是按字母顺序优先搜索，第一条找到的路径即为结果
        if(number==tickets.size()){
            result=new ArrayList<>(path);
        }
        else if(result==null){
            for(int i=0;i<city_names.length;i++){
                if((cities[pre][i]>0) && (result==null)){
                    path.addLast(get_key(i));
                    cities[pre][i]--;
                    search_result(number+1, i, tickets);
                    path.removeLast();
                    cities[pre][i]++;
                }
            }
        }
    }

    public static String get_key(int value){
        for(int i=0;i<city_names.length;i++){
            if(names_number.get(city_names[i])==value){
                return city_names[i];
            }
        }

        return "";
    }

    public static void main(String[] args){
        String[][] tickets_array={{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"}
        ,{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        List<List<String>> tickets=new ArrayList<List<String>>();
        for(int i=0;i<tickets_array.length;i++){
            LinkedList<String> temp=new LinkedList<>();
            for(int j=0;j<2;j++){
                temp.add(tickets_array[i][j]);
            }
            tickets.add(new ArrayList<>(temp));
        }
        List<String> result_lists=findItinerary(tickets);
    } 
    
}
