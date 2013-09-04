/* COE 2SI4 - Project 2 */
import java.io.*;
public class spellChecker implements SpChecker{
    String [] hash = new String [76000];
    /** Creates a new instance of spellChecker */
    public spellChecker() {
    }
    
    public int getIndex(String Str){
        int index = 0;
        int j =0;
        while(j<4 && j<Str.length()){
            if(j==0){index += 3000*(Str.charAt(j)-97);}
            else if(j==1){
                if(Str.charAt(j)<97 || Str.charAt(j)>122){index += 115*(Str.charAt(0)-97);}
                else{index += 115*(Str.charAt(j)-97);}
            }
            else if(j==2){
                if(Str.charAt(j)<97 || Str.charAt(j)>122){index += 5*(Str.charAt(0)-97);}
                else{index += 5*(Str.charAt(j)-97);}
            }
            else{
                if(Str.charAt(j)<97 || Str.charAt(j)>122){index += Str.charAt(0)-97;}
                else{index += Str.charAt(j)-97;}
            }
            j++;
        }
        if(index>75999){
            index %= 75999;
        }
        return index;
    }
    
    public void retrieve(String S){
        String k;
        Result temp;
        try{
            BufferedReader in = new BufferedReader(new FileReader(S));
            while((k=in.readLine())!=null){
                temp = check(k);
                if(!temp.found){
                    add(k);
                }
            }
            in.close();
        }
        catch(IOException e){
                System.out.println(e);
        }
    }

    public Result check(String s) {
        Result t;
        int ind = getIndex(s);
        int count = 0;
        while(hash[ind]!=null){
            count++;
            if(hash[ind].equals(s)){
                t = new Result(true, count, "no sugestion");
                return t;
            }
            else{ind++;}
        }
        if(ind==0 || hash[ind-1]==null){t = new Result(false, count+1, "no sugestion");}
        else{t = new Result(false, count+1, hash[ind-count]);}
        return t;
    }

    public Result add(String s) {
        Result t = new Result();
        int ind = getIndex(s);
        while(hash[ind]!=null){
            ind++;
        }
        hash[ind] = s;
        return t;
    }
    
    
}
