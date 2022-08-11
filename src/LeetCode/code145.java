// 标记法，后序遍历
// 这里的标记的意思，按前/中/后序将节点push入栈，然后根据节点的标记（同样在栈中）确认其是否已入过栈，如果是入栈后又弹出的元素，则可确定输出
package LeetCode;
import tools.binary_tree;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class code145 {

    public static List<Integer> postorderTraversal(binary_tree root) {
        List<Integer> results=new ArrayList<>();
        Stack<binary_tree> stack_tree=new Stack<>();
        if(root==null){
            return results;
        }
        else{
            //理清后序标记逻辑
            stack_tree.push(root);
            binary_tree cur_node;
            while(!stack_tree.isEmpty()){
                // 确定栈顶元素
                cur_node=stack_tree.peek();
                // 判断是不是已遍历的元素
                // 通过向栈中push标识符来处理识别问题，对已遍历过得，push一个null来区分
                // 当curnode指向null后，下一个节点的value弹出到结果队列
                if(cur_node!=null){
                    // 弹出当前节点
                    cur_node=stack_tree.pop();
                    // 标记已遍历，左右根的顺序，这里是按处理先后，那push入栈就是根右左
                    stack_tree.push(cur_node);
                    stack_tree.push(null);
                    if(cur_node.right!=null){
                        stack_tree.push(cur_node.right);
                    }
                    if(cur_node.left!=null){
                        stack_tree.push(cur_node.left);
                    }
                }
                else{
                    // 弹出null
                    stack_tree.pop();
                    cur_node=stack_tree.pop();
                    results.add(cur_node.value);
                }
            }
            return results;
        }
        
    }

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(3);
        binary_tree leaf_01=new binary_tree(1);
        binary_tree leaf_02=new binary_tree(2);
        root_01.left=leaf_01;
        root_01.right=leaf_02;
        postorderTraversal(root_01);
    } 
}
