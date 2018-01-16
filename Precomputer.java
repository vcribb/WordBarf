import java.util.*;
import java.io.*;

public class Precomputer{

    /*determines if two words have a difference of exactly one letter*/
    public static boolean adjacent(String a, String b){
	if (a.length() != b.length()){
        return false;
    }
    int count = 0;
                
	//count determines how many letters the two strings have in common
	for(int i = 0; i < a.length(); i ++){
	    if(a.charAt(i) != b.charAt(i)){
		count++;
	    }	    
	}
	return count == 1;
    }

    public static void main(String[] args){
	ArrayList<String> ans = new ArrayList<String>();
	try{
	    File f = new File("EnglishWords.txt");
	    Scanner reader = new Scanner(f);
	    while(reader.hasNext()){
		ans.add(reader.next());
	    }
	    System.out.println(ans);
	    //copies the five-letter English words into ans
	}catch(FileNotFoundException e){
	    
	}
	for(int i = 0; i < ans.size(); i++){
	    String wordsForI = "";
	    for (int j = 0; j < ans.size(); j++){
		if( adjacent(ans.get(i),ans.get(j))){
		    wordsForI += j + " " ;
		}
	    }
	    //System.out.println(ans.get(i) + " " + wordsForI); 
	    //System.out.println("\n\n\n\n\n");
	    //prints a word followed by its adjacent words
	}
    }
}
    
    
