import java.util.*;
import java.io.*;

public class Precomputer{

    public static boolean adjacent(String a, String b){
	int count = 0;
	for(int i = 0; i < a.length(); i ++){
	    if(a.charAt(i) == b.charAt(i)){
		count++;
	    }
	    
	}

	return count == 1;

    }



    
    public static void main(String[] args){
	try{
	ArrayList<String> ans = new ArrayList<String>();
	File f = new File("FourLetterWords.txt");
	Scanner reader = new Scanner(f);
	while(reader.hasNext()){
	    ans.add(reader.next());
	}
	
	System.out.println( ans);
		
		
	}catch(FileNotFoundException e){
	    
	    //
	    
	    
	}
    
    
    
    for(int i = 0; i < ans.size(); i++){
	String wordsForI = "";
	for ( int j = 0; j < ans.size(); j++){
		if( adjacent(ans.get(i), ans.get(j))){
		    wordsForI += ans.get(j) + ' ';
		}
		    
	       
	    }
	System.out.println(ans.get(i) + " : " + wordsforI); 
    }
    



    }








    
    }
    
    
