package tools;

public class RB_tree_node<T extends Comparable<T>> {
    // 0红1黑
    public Boolean color;
    public T key;
    public RB_tree_node<T> parent;
    public RB_tree_node<T> left;
    public RB_tree_node<T> right;

    // 构造函数
    public RB_tree_node(){

    }

    public RB_tree_node(T key){
        this.key=key;
    }

    public RB_tree_node(Boolean color,T key){
        this.color=color;
        this.key=key;
    }
    
}
