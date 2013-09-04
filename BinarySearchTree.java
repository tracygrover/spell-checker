/*
 COE 2SI4 - Project 2
Author: (Prateek Peereddy, 0672434, peeredpr@mcmaster.ca)
 *      (Esha Tracy Grover, 0771212, grover_tracy@hotmail.com)
--------------------------------------------------
Program Description:
Inputs:
Outputs:
 */

import java.io.*;
public class BinarySearchTree implements SpChecker {
    TNode root,currentNode;
    
    public BinarySearchTree(){
        root=null;
        currentNode=null;
    }
    
    public Result add(String word){
        currentNode=new TNode(word);
        if(root==null){
            root=currentNode;
        }
	else{
            TNode temp=root;
            while(true){
                if (temp.element.compareTo(currentNode.element)<0){
                    if(temp.right==null){
                        temp.right=currentNode;
                        break;
                    }
                    else{
                        temp=temp.right;
                    }
                }
                else if(temp.element.compareTo(currentNode.element)>0){
                    if (temp.left==null){
                        temp.left=currentNode;
                        break;
                    }
                    else{
                         temp=temp.left;
                    }
                }
            }
        }
        return null;
    }
    

    public Result checkIsIn(String word,TNode t){
        String suggestion="",found="";
        int count=0;
        Result r;
        while(t!=null){
            suggestion =t.element;
            count++;
           // currentNode=t;
            if (word.compareTo(t.element)==0){
               found ="None : word "+t.element+"found in dictionary";
               r = new Result(true, count,found);
               return r;
            }
            else if(word.compareTo(t.element)>0){  
              t = t.right;
              }
            else if(word.compareTo(t.element)<0){
              t = t.left; 
              }
            
         }
        suggestion="The word may be missppelled \n Try considering "+suggestion ;
        r = new Result(false,count, suggestion);
        return r;
    }

    public Result check(String s){
         Result res=new Result();
         res=checkIsIn(s,root);
         return res;
     }     
public void print(TNode t){
    if(t!=null)
    {
        
        print(t.left);
        System.out.println(t.element);
        print(t.right);
    }
    
}    
    
}
