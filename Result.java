/* COE 2SI4 - Project 2 */

public class Result{
    boolean found;
    int numProbes;
    String suggestion;
    
    public Result(){
        found = false;
        numProbes = 0;
        suggestion = "No Suggestions";
    }
    
    public Result(boolean f, int nP, String s){
        found = f;
        numProbes = nP;
        suggestion = s;
    }
    // outputs textual representation of object
    public String toString(){
        String printString = "";
        if(found){
            printString+="found\t";
        }
        else{
            printString+="not found\t";
        }
        printString+="Probes : "+numProbes+"\t";
        printString+=suggestion+"\n";
        return printString;
    }
}
