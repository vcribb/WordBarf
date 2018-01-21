import java.util.*;
import java.io.*;

public class Precomputer{

    /*determines if two words have a difference of exactly one letter*/
    
    public static boolean adjacent(String a, String b){
	if(a.length() == b.length()){
	    int count = 0;
	    for (int i = 0; i < a.length(); i++){
		if (a.charAt(i) != b.charAt(i)){
		    count++;
		}
	    }
	    return count == 1;


	}
	return false;


    }
    /*
    public static boolean adjacent(String a, String b){
	if (a.length() != b.length()){
	    if (a.length() == b.length()-1){
		int badindex = a.length();
		for (int i = 0; i < a.length(); i++){
		    if (a.charAt(i) != b.charAt(i)){
			badindex = i;
		    }
		}
		String s = b.substring(0,badindex) +
		    b.substring(badindex + 1,b.length());
		int count = 0;
		for (int i = 0; i < a.length(); i++){
		    if (a.charAt(i) != s.charAt(i)){
			count++;
		    }
		}
		return count == 0;
	    }
	    if (b.length() == a.length()-1){
		int badindex = b.length();
		for (int i = 0; i < b.length(); i++){
		    if (a.charAt(i) != b.charAt(i)){
			badindex = i;
		    }
		}
		String s = a.substring(0,badindex) +
		    a.substring(badindex + 1,a.length());
		int count = 0;
		for (int i = 0; i < b.length(); i++){
		    if (s.charAt(i) != b.charAt(i)){
			count++;
		    }
		}
		return count == 0;
	    }
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


    */

    public static void main(String[] args){
	ArrayList<String> ans = new ArrayList<String>();
	try{
	    File f = new File("EnglishWords.txt");
	    Scanner reader = new Scanner(f);
	    while(reader.hasNext()){
		//	if( reader.next().length() == 2){
		//System.out.println(reader.next());
		ans.add(reader.next());
		    //	}
	    }
	    //  System.out.println(ans);
	    //copies the five-letter English words into ans
	}catch(FileNotFoundException e){
	    
	}
    
	try(FileWriter fw = new FileWriter("EnglishConnections.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw)){
    
	for(int i = 0; i < ans.size(); i++){
	    String wordsForI = "";

	    for (int j = 0; j < ans.size(); j++){
		if( adjacent(ans.get(i),ans.get(j))){
		    wordsForI += j + " " ;
		}
	    }
	    out.println(ans.get(i) + " " + wordsForI);
	    System.out.println(ans.get(i) + " " + wordsForI); 
	    //System.out.println("\n\n\n\n\n");
	    //prints a word followed by its adjacent words
	}
    
	    }catch (IOException e){
	    //Big dab
	}
    
    }
}
    
    
