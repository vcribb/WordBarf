import java.util.*;
import java.io.*;

public class testing{
    public static void main(String[] args){
        String line = "fish  ";
        String word = line.substring(0,4);
        line = line.substring(5,line.length());
        String[] wordFam = line.split(" ");
        int[] wordFam2 = new int[wordFam.length];
        for(int x = 0; x < wordFam.length; x++){
            wordFam2[x] = Integer.parseInt(wordFam[x]);
            
        }
       
        for(int x = 0; x < wordFam.length; x++){
            System.out.println(wordFam2.length);
            System.out.println(" * " + wordFam2[x] + " * ");
            
        }
    
        System.out.println(wordFam2.length);
    }
    
    
}