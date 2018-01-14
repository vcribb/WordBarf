import java.util.*;
import java.io.*;

public class Word5{
    
    private String word; //stores a five-letter English word

    private Word5[] linksTo; //stores adjacent five-letter English words
   
    private int distance; //the number of letters in the word that differ from
    //the starting word

    public Word5(){
        distance = 5757;
    }

    //accessor for the distance variable
    public int getDistance(){
        return distance;
    }

    //setter for the distance variable
    public void setDistance(int d){
         distance = d;
    }

    //accessor for the word variable
    public String getWord(){
        return word;
    }
    
    public void branch(int d){
        for(int i = 0; i < linksTo.length; i++){
            if(linksTo[i].getDistance() == 5757){
                linksTo[i].setDistance(d);
            }
        }
    }
    
    public boolean branched(){
        for(int i = 0; i < linksTo.length; i++){  
            if(linksTo[i].getDistance() == 5757){
                return false;
            }
        }
        return true;
    }
    
    public Word5 backTrack(){
        int mindex = 0;
        for(int i = 0; i < linksTo.length; i ++){
            if(linksTo[i].getDistance() < linksTo[mindex].getDistance()){
                mindex = i;
            }
        }
        return linksTo[mindex];
    }
    
    public void makeLinks(int[] indices, Word5[] wordList){
       linksTo = new Word5[indices.length];
       for(int i = 0; i < indices.length; i++){
           linksTo[i] = wordList[indices[i]];
       }   
    }
    
    public int[] parseLine(String line){
        word = line.substring(0,5);
        line = line + "   ";
        line = line.substring(6,line.length());
        String[] wordFam = line.split(" ");
        int[] wordFam2 = new int[wordFam.length];
        for(int x = 0; x < wordFam.length; x++){
            wordFam2[x] = Integer.parseInt(wordFam[x]);
	    
        }
        return wordFam2;
    }

    public static boolean isEnglish(String word){
	try{
	    File f = new File("FiveLetterWords.txt");
	    Scanner in = new Scanner(f);
	    String s = "";
	    while (in.hasNext()){
		s += in.next() + " ";
		//System.out.println(s);
	    }
	    in.close();
	    String[] split = s.split(" ");
	    for (int x = 0; x < split.length; x++){
		if (split[x].equals(word)){
		    return true;
		}
	    }
	}
	catch(FileNotFoundException e){
	    System.exit(1);
	}
	return false;
    }
    
    public static void directions(){
	System.out.println("Welcome to Word Barf!");
	System.out.println("This is a program that takes two four-letter English words and prints");
	System.out.println("a string of words going from one to the other changing one letter at a time.");
	System.out.println("Please enter the word you would like to start with,");
	System.out.println("followed by the word you would like to end with in the following format:");
	System.out.println("java Word startWord endWord");
	System.out.println("Thank you!");
    }
    
    public static void main (String[] args){
	if (args.length == 2){
		Word5[] words = new Word5[5757];
        
		for(int i = 0; i < words.length; i++){
		    words[i] = new Word5();
		}
     
		try{
		    File f = new File("adjacentWords5.txt");
		    Scanner reader = new Scanner(f);
		    int i = 0;
		    while(reader.hasNext()){  
			words[i].makeLinks(words[i].parseLine(reader.nextLine()), words);
			i++;
		    }
		}catch(FileNotFoundException e){
            
		}
          
		String startW = args[1];
		String endW = args[0];

			if (!isEnglish(startW) || !isEnglish(endW)){
		    directions();
		    System.exit(1);
			}
        
        
		for(int i = 0; i < words.length; i++){
		    if(words[i].getWord().equals(startW)){
			words[i].setDistance(0);
		    }
		}
        
        
		boolean found = false;
		boolean allFull = false;
		for(int i = 0; !allFull &&  !found ; i++ ){
		    allFull = true;
		    for(int j = 0; j < words.length; j++){
			if(words[j].getDistance() == i){
			    allFull = allFull && words[j].branched(); 
			    words[j].branch(i + 1);
                    
			    //System.out.println(words[j].getWord());
			    //System.out.println(words[j].getDistance());
			}
			if(words[j].getWord().equals(endW) && words[j].getDistance() < 5757){
			    //System.out.println(words[j].getDistance());
			    found = true;
			}
		    }
            
		}



		if(allFull){
		    System.out.println("Sorry there is no such path");
		    System.exit(1);
		}



		
		//System.out.println(allFull);
		System.out.println(endW);
		boolean done = false;
		Word5 on = new Word5();
        
		for(int x = 0; x < words.length; x++){
		    if(words[x].getWord().equals(endW)){
			on = words[x];
		    }
            
		}
        
		while(on.getDistance() != 0){
		    on = on.backTrack();
		    System.out.println(on.getWord());
		}
	    }
	    else{
		directions();
	    }
    }
}

