package tools;

public class binary_tree {
    public int value;
    public binary_tree left;
    public binary_tree right;

    public binary_tree(){
        
    }

    public binary_tree(int value){
        this.value=value;
    }

    public binary_tree(int value,binary_tree left,binary_tree right){
        this.value=value;
        this.left=left;
        this.right=right;
    }
}
