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
import java.util.*;
public class TestSpChecker {
    
    static BinarySearchTree t=new BinarySearchTree();
    static ArrayList<String> array1= new ArrayList<String>(25000);

    
//    public static void main(String [] args){
//        spellChecker proj = new spellChecker();
//        Result res;
//        proj.retrieve("dictionary.txt");
//        try{
//            String St;
//            BufferedReader in = new BufferedReader(new FileReader(args[0]));
//            BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
//            while((St = in.readLine())!=null){
//                res = proj.check(St);
//                out.write(St+"\t"+res);
//                out.newLine();
//            }
//            in.close();
//            out.close();
//        }
//        catch(IOException e){
//                System.out.println(e);
//        }
//    }
    
    public static void rec_insert(int a, int b) {
        int mid=0;
        if (b>=a){
            mid = (b+a)/2;
            
        t.add((String)array1.get(mid));
        rec_insert(a,mid-1);
	rec_insert(mid+1,b);
        }
    }
     
    public static void main(String args[]){
        TNode root, currentNode;
        String word;
        Result res = new Result();
        int size=0,i=0; 
        try{
            BufferedReader fileIn=new BufferedReader(new FileReader("dictionary.txt"));
            while((word=fileIn.readLine())!=null){  
                array1.add(word);
            }
            fileIn.close();
            size=array1.size();
            rec_insert(0,size-1);
            BufferedReader input=new BufferedReader(new FileReader(args[0]));
            BufferedWriter output=new BufferedWriter(new FileWriter(args[1]));
            String result="";
            
            while((word=input.readLine())!=null){
                res=t.check(word);
                if(res.found){
                    result=word + "\t Found = " + res.found + "\t NumofProbes = " + res.numProbes + " Suggestion = NULL";
                }
                else{
                    result=word+ "\t Found = " + res.found + "\t NumofProbes = " + res.numProbes + "  Suggestion = " + res.suggestion;
                }
                output.write(result);
                output.newLine();
            }
            input.close();
            output.close();
        }
        catch(Exception e){
            System.out.println("\n file not found");
        }
     }
}
