/* COE 2SI4 - Project 2 */

public class TNode {
    String element;
    TNode left;
    TNode right;
 
    public TNode(){
        setNode("",null,null);
    }
 
    public TNode(String element){
        setNode(element,null,null);
    }

    public TNode(String element,TNode left, TNode right ){ 
        setNode(element,left,right);
    }
 
    public void setNode(String element,TNode left,TNode right){
        this.element=element;
        this.left=left;
        this.right=right;
    }
}
