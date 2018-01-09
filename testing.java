import java.util.*;
import java.io.*;

public class testing{
    public static void main(String[] args){
        String line = "fish 324 54532 23 34";
        String word = line.substring(0,4);
        line = line.substring(4,line.length());
        String[] wordFam = line.split(" ");
        int[] wordFam2 = new int[wordFam.length];
        for(int x = 0; x < wordFam.length; x++){
            wordFam2[x] = Integer.parseInt(wordFam[x]);
	    
        }
       
        
        
    }
    
}