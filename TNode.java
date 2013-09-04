/*
 COE 2SI4 - Project 2
Author: (Prateek Peereddy, 0672434, peeredpr@mcmaster.ca)
 *      (Esha Tracy Grover, 0771212, grover_tracy@hotmail.com)
--------------------------------------------------
Program Description:
Inputs:
Outputs:
 */

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
