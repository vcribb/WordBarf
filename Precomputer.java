import java.util.*;
import java.io.*;

public class Precomputer{
    public static void main(String[] args){
	try{
	ArrayList<String> ans = new ArrayList<String>();
	File f = new File("FourLetterWords.txt");
	Scanner reader = new Scanner(f);
	while(reader.hasNext()){
	    ans.add(reader.next());
		    }
		
		System.out.println( ans);
	    
	   
    }catch(FileNotFoundexception e){
	    
	//


	}
    }
	
    }
    
    
