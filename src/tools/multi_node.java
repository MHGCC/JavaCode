package tools;

import java.util.List;

public class multi_node {
    public int val;
    public List<multi_node> children;
    
    public multi_node() {}
    
    public multi_node(int _val) {
        val = _val;
    }
    
    public multi_node(int _val, List<multi_node> _children) {
        val = _val;
        children = _children;
    }
}
